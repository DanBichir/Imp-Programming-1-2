/*
The target of the program is to override the function "==".

However, the initial method uses type "Any" while ours uses "Rectangle", resulting in overload of our function.

Because of this, the override fails and the original equals function will take priority.
*/
