import os
def calculate_language_percentage(directory):
    language_counts = {}
    total_files = 0

    for root, dirs, files in os.walk(directory):
        total_files += len(files)
        for dir in dirs:
            language_counts[dir] = language_counts.get(dir, 0) + 1

    language_percentages = {
        language: (count / total_files) * 100
        for language, count in language_counts.items()
    }

    return language_percentages