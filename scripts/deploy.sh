#!/bin/bash

# -----------------------------
# iGame-center Deployment Script
# -----------------------------

# 1️⃣ Navigate to project directory (adjust if needed)
cd "$(dirname "$0")"

echo "📂 Current directory: $(pwd)"

# 2️⃣ Compile TeX files into PDFs
echo "📄 Compiling .tex update files..."
for texfile in updates/*.tex
do
    if [ -f "$texfile" ]; then
        echo "Compiling $texfile ..."
        pdflatex "$texfile" > /dev/null
    fi
done
echo "✅ All TeX files compiled."

# 3️⃣ Add changes to Git
echo "💾 Adding files to Git..."
git add .

# 4️⃣ Commit changes
echo "✏️ Enter commit message:"
read commit_message
git commit -m "$commit_message"

# 5️⃣ Push to GitHub
echo "🚀 Pushing to GitHub..."
git push origin main

# 6️⃣ Optional: Start backend server locally
echo "🖥️ Starting GraphQL backend..."
# Run in background
nohup node server.js > server.log 2>&1 &

# 7️⃣ Open game in default browser
echo "🌐 Opening index.html..."
open src/core/index.html  # Mac
# For Linux use: xdg-open src/core/index.html
# For Windows use: start src\core\index.html

echo "🎉 Deployment script completed!"
