import sys, getopt

def writeToFile(f, aString):
	f.write(aString)



def main():
	print 'Number of arguments:', len(sys.argv), 'arguments.'
	print 'Argument List:', str(sys.argv)
	filename = sys.argv[1] + ".txt"
	f = open(filename, 'r')
	out = open(sys.argv[1]+ "Out.txt", 'w')
	firstOff = True;
	if f:
		for line in f:
			print line
			array = line.split(' ')
			numbers = []
			for word in array:
				if word.isdigit():
					numbers.append(word)
			print numbers
			if firstOff:
				writeToFile(out, "pulseIR(" + str(numbers[1]) + ");\n")
				firstOff = False
			else:
				if (int(numbers[0]) > 16000):
					num = int(numbers[0]) / 1000
					writeToFile(out, "delay(" + str(num) + ");\n")
				else:	
					writeToFile(out, "delayMicroseconds(" + str(numbers[0]) + ");\n")
				
				writeToFile(out, "pulseIR(" + str(numbers[1]) + ");\n")
				
		f.close()
		out.close()

	else:
		sys.exit(1)


if __name__ == "__main__":
   main()

