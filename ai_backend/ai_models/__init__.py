from .chatgpt_model import ChatGPTModel
from .claude_model import ClaudeModel
from .gemini_model import GeminiModel

models = {
    "chatgpt": ChatGPTModel,
    "gemini": GeminiModel,
    "claude": ClaudeModel,
}