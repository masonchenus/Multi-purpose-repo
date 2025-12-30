#!/usr/bin/env python3
"""
Content-Based Language Statistics Script
Analyzes file content to determine language percentages like GitHub Linguist.
Uses file extension AND content heuristics to detect languages.
"""

import os
import json
from collections import defaultdict

# Language signatures: maps file extensions and content patterns to languages
LANGUAGE_SIGNATURES = {
    # JavaScript variants
    '.js': 'JavaScript',
    '.mjs': 'JavaScript',
    '.cjs': 'JavaScript',
    '.jsx': 'JavaScript',
    '.jsm': 'JavaScript',
    '.jst': 'JavaScript',
    
    # TypeScript variants
    '.ts': 'TypeScript',
    '.mts': 'TypeScript',
    '.cts': 'TypeScript',
    '.tsx': 'TypeScript',
    
    # Python variants
    '.py': 'Python',
    '.pyc': 'Python',
    '.pyi': 'Python',
    '.pyx': 'Python',
    '.pyf': 'Python',
    
    # HTML files
    '.html': 'HTML',
    '.htm': 'HTML',
    
    # CSS files
    '.css': 'CSS',
    '.scss': 'CSS',
    '.sass': 'CSS',
    '.less': 'CSS',
    
    # Markdown
    '.md': 'Markdown',
    '.markdown': 'Markdown',
    '.mdown': 'Markdown',
    
    # C/C++
    '.c': 'C',
    '.h': 'C',
    '.cpp': 'C++',
    '.cc': 'C++',
    '.cxx': 'C++',
    '.hpp': 'C++',
    
    # C#
    '.cs': 'C#',
    
    # D
    '.d': 'D',
    
    # Go
    '.go': 'Go',
    
    # Rust
    '.rs': 'Rust',
    
    # Ruby
    '.rb': 'Ruby',
    
    # PHP
    '.php': 'PHP',
    
    # Haskell
    '.hs': 'Haskell',
    
    # Fortran
    '.f': 'Fortran',
    '.f90': 'Fortran',
    '.f95': 'Fortran',
    
    # CoffeeScript
    '.coffee': 'CoffeeScript',
    
    # Shell scripts
    '.sh': 'Shell',
    '.bash': 'Shell',
    '.fish': 'Shell',
    '.csh': 'Shell',
    
    # PowerShell
    '.ps1': 'PowerShell',
    
    # Java
    '.java': 'Java',
    
    # Kotlin
    '.kt': 'Kotlin',
    '.kts': 'Kotlin',
    
    # Scala
    '.scala': 'Scala',
    
    # Swift
    '.swift': 'Swift',
    
    # Objective-C
    '.m': 'Objective-C',
    '.mm': 'Objective-C',
    
    # R
    '.r': 'R',
    
    # Lua
    '.lua': 'Lua',
    
    # Perl
    '.pl': 'Perl',
    
    # Julia
    '.jl': 'Julia',
    
    # Elixir
    '.ex': 'Elixir',
    '.exs': 'Elixir',
    
    # Erlang
    '.erl': 'Erlang',
    
    # Clojure
    '.clj': 'Clojure',
    
    # F#
    '.fs': 'F#',
    
    # OCaml
    '.ml': 'OCaml',
    '.mli': 'OCaml',
    
    # SQL
    '.sql': 'SQL',
    
    # GraphQL
    '.graphql': 'GraphQL',
    
    # JSON
    '.json': 'JSON',
    '.jsonc': 'JSON',
    
    # YAML
    '.yml': 'YAML',
    '.yaml': 'YAML',
    
    # XML
    '.xml': 'XML',
    
    # TOML
    '.toml': 'TOML',
    
    # INI
    '.ini': 'INI',
    '.cfg': 'INI',
    '.conf': 'INI',
    
    # TeX/LaTeX
    '.tex': 'TeX',
    '.latex': 'TeX',
    
    # PDF (binary - counts as generated)
    '.pdf': 'PDF',
    
    # Images (binary - counted but not for language %)
    '.png': 'Image',
    '.jpg': 'Image',
    '.jpeg': 'Image',
    '.gif': 'Image',
    '.svg': 'Image',
    '.ico': 'Image',
    '.woff': 'Font',
    '.woff2': 'Font',
    '.ttf': 'Font',
    '.otf': 'Font',
    
    # Binary files
    '.so': 'Binary',
    '.dylib': 'Binary',
    '.exe': 'Binary',
    '.a': 'Binary',
    
    # Other
    '.txt': 'Text',
    '.log': 'Log',
    '.patch': 'Patch',
    '.lock': 'Lock',
    
    # Markdown-like documentation
    '.rst': 'reStructuredText',
    '.bnf': 'BNF',
    
    # Crystal
    '.cr': 'Crystal',
    
    # Nix
    '.nix': 'Nix',
    
    # WebAssembly
    '.wasm': 'WebAssembly',
    
    # Apache config
    '.apache': 'Apache Config',
    '.apache2': 'Apache Config',
    
    # Docker
    'Dockerfile': 'Dockerfile',
    '.dockerfile': 'Dockerfile',
}

# Content-based detection patterns (for files without clear extension)
CONTENT_PATTERNS = [
    (r'<!DOCTYPE\s+html', 'HTML'),
    (r'<html', 'HTML'),
    (r'<\?xml', 'XML'),
    (r'#!/usr/bin/env\s+(python|python3)', 'Python'),
    (r'#!/usr/bin/(python|python3)', 'Python'),
    (r'#!/usr/bin/env\s+(node|nodejs)', 'JavaScript'),
    (r'#!/usr/bin/(node|nodejs)', 'JavaScript'),
    (r'#!/bin/(ba)?sh', 'Shell'),
    (r'#!/usr/bin/env\s+(ba)?sh', 'Shell'),
    (r'use\s+strict', 'JavaScript'),
    (r'import\s+.*from', 'JavaScript'),
    (r'export\s+', 'JavaScript'),
    (r'def\s+\w+\s*\(', 'Python'),
    (r'class\s+\w+', 'Python'),
    (r'func\s+\w+', 'Go'),
    (r'struct\s+\w+', 'Go'),
    (r'type\s+\w+\s+struct', 'Go'),
]

def detect_language_by_content(filepath, first_bytes):
    """Detect language based on file content."""
    content = first_bytes.lower()
    
    # Check content patterns
    for pattern, lang in CONTENT_PATTERNS:
        if pattern in content:
            return lang
    
    return None

def get_file_language(filepath):
    """Determine language for a file based on extension and content."""
    filename = os.path.basename(filepath)
    
    # Check exact filename matches first
    if filename in LANGUAGE_SIGNATURES:
        return LANGUAGE_SIGNATURES[filename]
    
    # Get extension
    ext = os.path.splitext(filename)[1].lower()
    
    # Check extension
    if ext in LANGUAGE_SIGNATURES:
        return LANGUAGE_SIGNATURES[ext]
    
    # Try content-based detection for files without recognized extensions
    try:
        with open(filepath, 'rb') as f:
            first_bytes = f.read(500).decode('utf-8', errors='ignore')
        return detect_language_by_content(filepath, first_bytes)
    except:
        return 'Unknown'

def count_bytes_by_language(directory):
    """Count bytes by language in the given directory and all subdirectories."""
    language_bytes = defaultdict(int)
    language_files = defaultdict(int)
    total_bytes = 0
    total_files = 0
    undetermined = 0
    
    for root, dirs, files in os.walk(directory):
        for filename in files:
            filepath = os.path.join(root, filename)
            
            # Skip binary files and non-code files for language stats
            skip_extensions = {'.png', '.jpg', '.jpeg', '.gif', '.ico', '.pdf', 
                             '.so', '.dylib', '.exe', '.a', '.woff', '.woff2',
                             '.ttf', '.otf', '.map', '.pyc', '.lock', '.gz',
                             '.zip', '.tar', '.tar.gz'}
            
            ext = os.path.splitext(filename)[1].lower()
            if ext in skip_extensions:
                # Count as data but not for language percentages
                try:
                    size = os.path.getsize(filepath)
                    total_bytes += size
                except:
                    pass
                continue
            
            try:
                size = os.path.getsize(filepath)
                total_bytes += size
                total_files += 1
                
                # Determine language
                lang = get_file_language(filepath)
                
                if lang and lang not in ['Unknown', 'Text', 'Log', 'Patch', 
                                         'Lock', 'Font', 'Image', 'Binary', 
                                         'PDF', 'INI', 'JSON', 'YAML', 'XML',
                                         'Apache Config', 'Dockerfile']:
                    language_bytes[lang] += size
                    language_files[lang] += 1
                else:
                    undetermined += size
                    
            except (OSError, IOError):
                continue
    
    return language_bytes, language_files, total_bytes, total_files, undetermined

def calculate_percentages(language_bytes, total_bytes):
    """Calculate percentage for each language based on bytes."""
    if total_bytes == 0:
        return {}
    
    percentages = {}
    for lang, bytes_count in sorted(language_bytes.items(), 
                                     key=lambda x: x[1], reverse=True):
        percentages[lang] = {
            'bytes': bytes_count,
            'percentage': round((bytes_count / total_bytes) * 100, 2)
        }
    return percentages

def print_stats(directory):
    """Print language statistics based on content/bytes."""
    language_bytes, language_files, total_bytes, total_files, undetermined = \
        count_bytes_by_language(directory)
    
    percentages = calculate_percentages(language_bytes, total_bytes)
    
    print(f"\n{'='*70}")
    print(f"CONTENT-BASED LANGUAGE STATISTICS (GitHub-style)")
    print(f"{'='*70}")
    print(f"Directory: {directory}")
    print(f"Total Code Files: {total_files}")
    print(f"Total Bytes Analyzed: {total_bytes:,}")
    print(f"{'-'*70}")
    print(f"{'Language':<20} {'Files':<10} {'Bytes':<15} {'Percentage':<15}")
    print(f"{'-'*70}")
    
    for lang, data in percentages.items():
        file_count = language_files.get(lang, 0)
        bytes_count = data['bytes']
        percentage = data['percentage']
        bar = '█' * int(percentage / 2)
        print(f"{lang:<20} {file_count:<10} {bytes_count:>12,} {percentage:>6.2f}% {bar}")
    
    print(f"{'-'*70}")
    print(f"Undetermined/Config: {undetermined:,} bytes")
    print(f"{'='*70}\n")
    
    return percentages

def save_stats_to_json(percentages, language_files, output_file):
    """Save statistics to a JSON file."""
    output = {
        'languages': percentages,
        'file_counts': dict(language_files),
        'generated_from': 'content-language-stats.py'
    }
    with open(output_file, 'w') as f:
        json.dump(output, f, indent=2)
    print(f"Stats saved to: {output_file}")

if __name__ == "__main__":
    import sys
    
    # Default directory is current working directory
    directory = sys.argv[1] if len(sys.argv) > 1 else "."
    
    # Calculate and print stats
    percentages = print_stats(directory)
    
    # Save to JSON
    language_bytes, language_files, total_bytes, total_files, undetermined = \
        count_bytes_by_language(directory)
    output_file = "content_language_stats.json"
    save_stats_to_json(percentages, language_files, output_file)

