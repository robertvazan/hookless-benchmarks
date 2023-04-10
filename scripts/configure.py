# This script generates and updates project configuration files.

# Run this script with rvscaffold in PYTHONPATH
import rvscaffold as scaffold

class Project(scaffold.Java):
    def script_path_text(self): return __file__
    def repository_name(self): return 'hookless-benchmarks'
    def pretty_name(self): return 'Hookless Benchmarks'
    def pom_description(self): return 'JMH benchmarks for Hookless reactive library.'
    def inception_year(self): return 2020
    def jdk_version(self): return 17
    def jmh_benchmarks(self): return True
    def stagean_annotations(self): return True
    def is_library(self): return False
    def has_website(self): return False
    def project_status(self): return f'{self.experimental_status()} This is a stub project. Thorough testing of Hookless would require many more benchmarks.'
    def md_description(self): return '''\
        [JMH](https://openjdk.java.net/projects/code-tools/jmh/) benchmarks for [Hookless](https://hookless.machinezoo.com/) reactive programming library.
        
        Latest results are archived in [JMH JSON file](https://cdn.machinezoo.com/jmh/hookless-benchmarks.json).
        They can be visualized on [jmh.morethan.io](https://jmh.morethan.io/?source=https://cdn.machinezoo.com/jmh/hookless-benchmarks.json).
    '''
    
    def dependencies(self):
        yield from super().dependencies()
        yield self.use_hookless()

Project().generate()
