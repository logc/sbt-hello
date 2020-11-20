# sbt-hello: a minimal working example of an SBT plugin

## Motivation

Starting to develop my first SBT plugin, I found the [SBT Reference Manual
documentation](https://www.scala-sbt.org/1.x/docs/Plugins.html) confusing. Some
of the initial examples do not compile, or they do not compile because the
template used by SBT itself for a new project does not play well with developing
an SBT plugin.

Whatever that might be, I wished for a Github repository that would show to me
what a minimal working example would be. Since I did not found one, I created
this.

## What to look out for

Note that the `build.sbt` file *does not prescribe the Scala version*. This is
something that the default template adds but is at odds with the versions of SBT
that work with versions of Scala. For reference, in [this
issue](https://github.com/sbt/sbt/issues/5032) of the SBT repository, the
authors explain that

> Scala version should not be specified unless you're cross building between sbt
> 1.x and 0.13. There's no sbt available under 2.13.0, so expectation doesn't
> make sense

Since the current stable version of Scala -as of Nov 2020- is 2.13, the default
template used on `sbt new scala/scala-seed.g8` sets it to be the Scala version
used in `ThisBuild`. This leads to a compilation error even for the most minimal
SBT plugin.

Also note that the `Dependencies.scala` file lists `scalatest` as a dependency
but is not used anywhere. This is a leftover from the initial template. I did
not bother to remove it since it is probably useful if you want to develop on
top of this example.

## Installation

To use this plugin from other projects in development, you can publish it to
your local Ivy or Maven repository:

```shellsession
$ sbt
sbt:sbt-hello> publishLocal
```

## Usage

To use this plugin from another local project, add it to the
`project/plugins.sbt` file:

``` scala
addSbtPlugin("com.github.logc" %% "sbt-hello" % "0.1.0-SNAPSHOT")
```

Then reload (or restart) your SBT shell, and use the plugin by using the `hello`
task:

``` shellsession
sbt:project> reload
sbt:project> hello
Hi!
[success] Total time: 0 s, completed Nov 20, 2020 10:48:40 AM
```

## License

See LICENSE file
