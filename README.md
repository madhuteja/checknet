# checknet
A simple library to check android network status.


## Download

Gradle
```groovy

```

## How to use?
Very simple. Just in one line.

### Kotlin
Check network available or not

```kotlin
val isConnected = CheckConnection.with(context).isConnected
if(isConnected){
  //do network request 
}
```

Check network type
```kotlin
val connectionType = CheckConnection.with(context).connectionType
if(ConnectionType.WI_FI == connectionType){
  //download large file
}
```

Execute a function if network is available
```kotlin
CheckConnection.with(context).ifConnected {
            //do network request
        }
```    

```kotlin
val value = 2
val newValue = CheckConnection.with(context).ifConnected<Int> {
            value + 5
        }
```        

### Java
Check network available or not
```java
boolean isConnected = CheckConnection.with(context).isConnected();
if(isConnected){
  //do network request 
}
```
Check network type
```java
ConnectionType connectionType = CheckConnection.with(context).getConnectionType();
if(ConnectionType.WI_FI == connectionType){
  //download large file
}
```
Execute a function if network is available

```java
CheckConnection.with(context).ifConnected(new Function0<Unit>() {
            @Override
            public Unit invoke() {
                //do network request
                return null;
            }
        });
```
```java
final int value = 2;
Integer newValue = CheckConnection.with(context).ifConnected(new Function0<Integer>() {
        @Override
         public Integer invoke() {
              return value + 5;
         }
      });
```



## License
```
MIT License

Copyright (c) 2017 Madhu Teja

Permission is hereby granted, free of charge, to any person obtaining 
a copy of this software and associated documentation files (the "Software"),
to deal in the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or 
substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, 
DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```

