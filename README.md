# RememberEditText
A EditText which can remember last input, free developer from managing cache everywhere themselves.

## Introduction
Have you been annoyed with entering the same stuff once and once like username, thread-reply? RememberEditText can remember the last several input automatically and offers directly choose them.

## How
RememberEditText simply puts its cache in SharedPreference, and keeps a local hashmap version to free from visiting SharedPreference everytime, thus speeds up its looks up and update.

## Usage
// not fin yet

## TODO
- Add more hint mode.
- Enable pair mode, like username/password.