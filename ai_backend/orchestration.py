# ai_backend/orchestrator.py
import os
import json

# Import all 50 modules
from modules import (
    game_generator, math_solver, slides_generator, helper_module, agent_module,
    tester_module, codegen_module, explain_module, summarizer_module, story_module,
    dialogue_module, brainstorming_module, outline_module, quiz_module, trivia_module,
    fact_check_module, translator_module, lyrics_module, poem_module, joke_module,
    cheat_sheet_module, code_review_module, optimization_module, design_module, diagram_module,
    debug_module, math_explain_module, data_analysis_module, recommendation_module, productivity_module,
    health_module, research_module, coding_challenge_module, game_tips_module, ranking_module,
    simulation_module, test_creator_module, logic_puzzle_module, riddle_module, comparison_module,
    planning_module, checklist_module, prompt_idea_module, generator_module, naming_module,
    stats_analyzer_module, visualization_module, feedback_module, creativity_module, documentation_module
)
from importlib import import_module

# Import AI models
from ai_backend import models

# ------------------------
# Paths for stats and billing
# ------------------------
STATS_FILE = "stats/stats.json"
BILLING_FILE = "billing/billing.json"

# ------------------------
# Helper functions
# ------------------------
def ensure_json(path, default):
    os.makedirs(os.path.dirname(path), exist_ok=True)
    if not os.path.exists(path):
        with open(path, "w") as f:
            json.dump(default, f)

def load_json(path):
    with open(path) as f:
        return json.load(f)

def save_json(path, data):
    with open(path, "w") as f:
        json.dump(data, f, indent=2)

# ------------------------
# BaseAI orchestrator
# ------------------------
class BaseAI:
    def __init__(self, ultra_mode=True):
        # Initialize stats and billing
        ensure_json(STATS_FILE, {"requests": 0})
        if ultra_mode:
            ensure_json(BILLING_FILE, {"credits": 10**12})  # Ultra dev credits
        else:
            ensure_json(BILLING_FILE, {"credits": 100})

        self.stats = load_json(STATS_FILE)
        self.billing = load_json(BILLING_FILE)

        # Map mode names to module functions
        self.modes = {
            "game": game_generator.game,
            "math": math_solver.math,
            "slides": slides_generator.slides,
            "helper": helper_module.helper_response,
            "agent": agent_module.agent_response,
            "tester": tester_module.tester,
            "codegen": codegen_module.codegen,
            "explain": explain_module.explain,
            "summarizer": summarizer_module.summarize,
            "story": story_module.story,
            "dialogue": dialogue_module.dialogue,
            "brainstorming": brainstorming_module.brainstorm,
            "outline": outline_module.outline,
            "quiz": quiz_module.quiz,
            "trivia": trivia_module.trivia,
            "fact-check": fact_check_module.fact_check,
            "translator": translator_module.translate,
            "lyrics": lyrics_module.lyrics,
            "poem": poem_module.poem,
            "joke": joke_module.joke,
            "cheat-sheet": cheat_sheet_module.cheat_sheet,
            "code-review": code_review_module.code_review,
            "optimization": optimization_module.optimize,
            "design": design_module.design,
            "diagram": diagram_module.diagram,
            "debug": debug_module.debug,
            "math-explain": math_explain_module.math_explain,
            "data-analysis": data_analysis_module.data_analysis,
            "recommendation": recommendation_module.recommendation,
            "productivity": productivity_module.productivity,
            "health": health_module.health,
            "research": research_module.research,
            "coding-challenge": coding_challenge_module.coding_challenge,
            "game-tips": game_tips_module.game_tips,
            "ranking": ranking_module.ranking,
            "simulation": simulation_module.simulation,
            "test-creator": test_creator_module.test_creator,
            "logic-puzzle": logic_puzzle_module.logic_puzzle,
            "riddle": riddle_module.riddle,
            "comparison": comparison_module.comparison,
            "planning": planning_module.planning,
            "checklist": checklist_module.checklist,
            "prompt-idea": prompt_idea_module.prompt_idea,
            "generator": generator_module.generator,
            "naming": naming_module.naming,
            "stats-analyzer": stats_analyzer_module.stats_analyzer,
            "visualization": visualization_module.visualization,
            "feedback": feedback_module.feedback,
            "creativity": creativity_module.creativity,
            "documentation": documentation_module.documentation
        }

    # ------------------------
    # Determine mode from prompt
    # ------------------------
    def parse_mode(self, prompt: str) -> str:
        prompt = prompt.lower()
        for mode_name in self.modes.keys():
            if mode_name in prompt:
                return mode_name
        return "helper"

    # ------------------------
    # Update stats and billing
    # ------------------------
    def log_request(self):
        self.stats["requests"] += 1
        self.billing["credits"] -= 1
        if self.billing["credits"] < 0:
            self.billing["credits"] = 0
        save_json(STATS_FILE, self.stats)
        save_json(BILLING_FILE, self.billing)

    # ------------------------
    # Handle AI request
    # ------------------------
    def handle_request(self, prompt: str, model_provider="chatgpt") -> dict:
        self.log_request()
        mode_name = self.parse_mode(prompt)
        module_func = self.modes.get(mode_name, self.modes["helper"])

        # Generate module response
        response = module_func(prompt)

        # Enhance response with selected AI model
        model = models.get(model_provider.lower(), models["chatgpt"])
        enhanced_response = model.generate(response)

        return {
            "mode": mode_name,
            "model_used": model_provider,
            "response": enhanced_response,
            "stats": self.stats,
            "billing": self.billing
        }

def run_user_mode(mode_name, input_data, user_id, session_id, model_name):
    """
    Dynamically calls the user-selected mode.
    """
    try:
        # Dynamically import the module from modules/
        mode_module = import_module(f"ai_backend.modules.{mode_name}")
        # Call the standardized run() function
        return mode_module.run(input_data, user_id=user_id, session_id=session_id, model_name=model_name)
    except Exception as e:
        from ai_backend.logger import error_logger
        error_logger.error(f"{user_id},{session_id},{model_name},{mode_name},{str(e)}")
        return f"Error: {str(e)}"

