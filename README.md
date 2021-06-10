# Monkey problem in Scala

## 1. First steps in Scala: basic tutorial using SBT
I followed this basic [tutorial](https://gist.github.com/deors/7f2acc09dca77dbc7b4508d0d2d9a34a) about how to set and use SBT.

In brief:

1. Create proyect's folder.
2. Create `build.sbt` file with this content:
```
name := "Monkey_Scala"
scalaVersion := "2.11.8"
```
3. Create sbt files by typing `sbt` on proyect's folder.
4. Create `src\main\scala\Monkey_Scala\HelloScala.scala` with:
```
object ClassicFirstProgram {
    def main(args: Array[String]): Unit = {
        println("Hello to the world of Scala!")
    }
}
```
5. In `sbt` execute:
```
compile
run
```

