> VO（View Object）：视图对象。
Controller在返回DTO给视图时，可能还需要包括状态信息例如操作成功/失败的状态码、提示文本等。这时就需要在DTO外面再包一层，即View Object。
该对象存在于Controller和Web之间.