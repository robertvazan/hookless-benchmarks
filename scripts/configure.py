# This script generates and updates project configuration files.

# We are assuming that project-config is available in sibling directory.
# Checkout from https://github.com/robertvazan/project-config
import os.path
import sys
sys.path.append(os.path.normpath(os.path.join(__file__, '../../../project-config/src')))

from java import *

project_script_path = __file__
repository_name = lambda: 'hookless-benchmarks'
pretty_name = lambda: 'Hookless Benchmarks'
pom_subgroup = lambda: 'hookless'
pom_description = lambda: 'JMH benchmarks for Hookless reactive library.'
inception_year = lambda: 2020
jdk_version = lambda: 11
jmh_benchmarks = lambda: True
stagean_annotations = lambda: True
is_library = lambda: False
has_website = lambda: False
project_status = lambda: f'{experimental_status()} This is a stub project. Thorough testing of Hookless would require many more benchmarks.'
md_description = lambda: '''\
    [JMH](https://openjdk.java.net/projects/code-tools/jmh/) benchmarks for [Hookless](https://hookless.machinezoo.com/) reactive programming library.
    
    Latest results are archived in [JMH JSON file](https://cdn.machinezoo.com/jmh/hookless-benchmarks.json).
    They can be visualized on [jmh.morethan.io](https://jmh.morethan.io/?source=https://cdn.machinezoo.com/jmh/hookless-benchmarks.json).
'''

def dependencies():
    use_hookless()

generate(globals())
