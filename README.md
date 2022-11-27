## How to run?
### To run from file
`java -jar markdowntohtml-1.0.jar file <path_to_file/file_name>`
###### Example
`java -jar markdowntohtml-1.0.jar FILE /Users/username/mdtohtml/src/test/resources/testFiles/test1.md`

### To run from stdin
In this mode, the input is processed one line at a time, to end conversion type "STOP"</br>
`java -jar markdowntohtml-1.0.jar stdin`

## What is handled?

Current implementation only handles the following:

| Markdown                               | HTML                                              |
| -------------------------------------- | ------------------------------------------------- |
| `# Heading 1`                          | `<h1>Heading 1</h1>`                              | 
| `## Heading 2`                         | `<h2>Heading 2</h2>`                              | 
| `...`                                  | `...`                                             | 
| `###### Heading 6`                     | `<h6>Heading 6</h6>`                              | 
| `Unformatted text`                     | `<p>Unformatted text</p>`                         | 
| `[Link text](https://www.example.com)` | `<a href="https://www.example.com">Link text</a>` | 
| `Blank line`                           | `Ignored`                                         | 
