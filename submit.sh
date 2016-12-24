# pandoc doc/report.md --latex-engine=xelatex -o doc/report.pdf
git log > doc/git.log
rm -rf 13307130225
mkdir 13307130225
cp README.md 13307130225/
cp doc/report.pdf 13307130225/
cp -r doc 13307130225/
cp -r src 13307130225/
cp -r test 13307130225/
rm 13307130225/src/*.class
rm -rf 13307130225/doc/img
