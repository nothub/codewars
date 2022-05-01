package simple_assembler_interpreter

// https://www.codewars.com/kata/58e24788e24ddee28e000053

import (
	"strconv"
	"strings"
)

type prog struct {
	code [][]string
	pntr int
}

func newProg(input []string) *prog {
	var code [][]string
	for _, inst := range input {
		code = append(code, strings.Split(inst, " "))
	}
	return &prog{code: code, pntr: 0}
}

func (prog prog) readInst() (string, string, string) {
	inst := prog.code[prog.pntr]
	if len(inst) > 2 {
		return inst[0], inst[1], inst[2]
	}
	return inst[0], inst[1], ""
}

func (prog prog) pntrValid() bool {
	return prog.pntr >= 0 && prog.pntr < len(prog.code)
}

type mem struct {
	regs map[string]int
}

func newMem() *mem {
	return &mem{regs: map[string]int{}}
}

func (tape mem) read(r string) int {
	return tape.regs[r]
}

func (tape mem) write(r string, i int) {
	tape.regs[r] = i
}

func (tape mem) resolve(s string) int {
	v, err := strconv.Atoi(s)
	if err != nil {
		v = tape.regs[s]
	}
	return v
}

func SimpleAssembler(program []string) map[string]int {
	mem := newMem()
	prog := newProg(program)
	for {
		if !prog.pntrValid() {
			break
		}
		o, x, y := prog.readInst()
		switch o {
		case "mov":
			mem.write(x, mem.resolve(y))
		case "inc":
			mem.write(x, mem.read(x)+1)
		case "dec":
			mem.write(x, mem.read(x)-1)
		case "jnz":
			if mem.resolve(x) != 0 {
				prog.pntr = prog.pntr + mem.resolve(y)
				prog.pntr--
			}
		}
		prog.pntr++
	}
	return mem.regs
}
