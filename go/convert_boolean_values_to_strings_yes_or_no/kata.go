package convert_boolean_values_to_strings_yes_or_no

// https://www.codewars.com/kata/53369039d7ab3ac506000467

func BoolToWord(word bool) string {
	if word {
		return "Yes"
	}
	return "No"
}
