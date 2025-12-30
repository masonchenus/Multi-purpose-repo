#!/usr/bin/env python3
"""
File Extension Statistics Script
Counts files by extension in a directory and its subdirectories,
then calculates the percentage of each file type.
"""

import os
import json
from collections import defaultdict

def count_files_by_extension(directory):
    """Count files by extension in the given directory and all subdirectories."""
    extension_counts = defaultdict(int)
    total_files = 0
    
    for root, dirs, files in os.walk(directory):
        for file in files:
            total_files += 1
            # Get file extension (without the dot)
            ext = os.path.splitext(file)[1].lower()
            if ext:
                extension_counts[ext] += 1
            else:
                extension_counts['(no extension)'] += 1
    
    return extension_counts, total_files

def calculate_percentages(extension_counts, total_files):
    """Calculate percentage for each extension with appropriate precision."""
    if total_files == 0:
        return {}
    
    percentages = {}
    for ext, count in sorted(extension_counts.items(), key=lambda x: x[1], reverse=True):
        raw_percentage = (count / total_files) * 100
        # Use dynamic precision: more decimals for smaller percentages
        if count == 1:
            # Show 4 decimal places for single files (0.00xx%)
            percentage = round(raw_percentage, 4)
        elif count < 10:
            # Show 3 decimal places for rare files
            percentage = round(raw_percentage, 3)
        else:
            # Show 2 decimal places for common files
            percentage = round(raw_percentage, 2)
        
        percentages[ext] = {
            'count': count,
            'percentage': percentage,
            'raw_percentage': raw_percentage  # Keep exact value for reference
        }
    return percentages

def print_stats(directory):
    """Print file extension statistics."""
    extension_counts, total_files = count_files_by_extension(directory)
    percentages = calculate_percentages(extension_counts, total_files)
    
    print(f"\n{'='*60}")
    print(f"FILE EXTENSION STATISTICS")
    print(f"{'='*60}")
    print(f"Directory: {directory}")
    print(f"Total Files: {total_files}")
    print(f"Unique Extensions: {len(extension_counts)}")
    print(f"{'-'*60}")
    print(f"{'Extension':<20} {'Count':<10} {'Percentage':<15}")
    print(f"{'-'*60}")
    
    for ext, data in percentages.items():
        count = data['count']
        percentage = data['percentage']
        # Dynamic formatting based on count
        if count == 1:
            fmt = f"{percentage:>8.4f}%"
        elif count < 10:
            fmt = f"{percentage:>8.3f}%"
        else:
            fmt = f"{percentage:>8.2f}%"
        
        # Visual bar based on raw percentage
        bar = '█' * int(data['raw_percentage'] / 2)
        print(f"{ext:<20} {count:<10} {fmt} {bar}")
    
    print(f"{'='*60}\n")
    return percentages

def save_stats_to_json(percentages, output_file):
    """Save statistics to a JSON file."""
    with open(output_file, 'w') as f:
        json.dump(percentages, f, indent=2)
    print(f"Stats saved to: {output_file}")

if __name__ == "__main__":
    import sys
    
    # Default directory is current working directory
    directory = sys.argv[1] if len(sys.argv) > 1 else "."
    
    # Calculate and print stats
    percentages = print_stats(directory)
    
    # Optionally save to JSON
    output_file = "file_extension_stats.json"
    save_stats_to_json(percentages, output_file)

