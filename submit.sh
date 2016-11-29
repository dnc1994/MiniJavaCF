pandoc doc/report.md --latex-engine=xelatex -o doc/report.pdf
git log > doc/git.log
rm -rf submission
mkdir submission
cp README.md submission/
cp doc/report.pdf submission/
cp -r doc submission/
cp -r src submission/
rm submission/src/*.class
cp -r test submission/
zip -r 13307130225.zip submission/
rm -rf submission