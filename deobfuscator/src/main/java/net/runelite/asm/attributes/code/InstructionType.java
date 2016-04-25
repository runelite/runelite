package net.runelite.asm.attributes.code;

import net.runelite.asm.attributes.code.instructions.AALoad;
import net.runelite.asm.attributes.code.instructions.AAStore;
import net.runelite.asm.attributes.code.instructions.AConstNull;
import net.runelite.asm.attributes.code.instructions.ALoad;
import net.runelite.asm.attributes.code.instructions.ALoad_0;
import net.runelite.asm.attributes.code.instructions.ALoad_1;
import net.runelite.asm.attributes.code.instructions.ALoad_2;
import net.runelite.asm.attributes.code.instructions.ALoad_3;
import net.runelite.asm.attributes.code.instructions.ANewArray;
import net.runelite.asm.attributes.code.instructions.AStore;
import net.runelite.asm.attributes.code.instructions.AStore_0;
import net.runelite.asm.attributes.code.instructions.AStore_1;
import net.runelite.asm.attributes.code.instructions.AStore_2;
import net.runelite.asm.attributes.code.instructions.AStore_3;
import net.runelite.asm.attributes.code.instructions.AThrow;
import net.runelite.asm.attributes.code.instructions.ArrayLength;
import net.runelite.asm.attributes.code.instructions.BALoad;
import net.runelite.asm.attributes.code.instructions.BAStore;
import net.runelite.asm.attributes.code.instructions.BiPush;
import net.runelite.asm.attributes.code.instructions.CALoad;
import net.runelite.asm.attributes.code.instructions.CAStore;
import net.runelite.asm.attributes.code.instructions.CheckCast;
import net.runelite.asm.attributes.code.instructions.D2F;
import net.runelite.asm.attributes.code.instructions.D2I;
import net.runelite.asm.attributes.code.instructions.D2L;
import net.runelite.asm.attributes.code.instructions.DALoad;
import net.runelite.asm.attributes.code.instructions.DAStore;
import net.runelite.asm.attributes.code.instructions.DAdd;
import net.runelite.asm.attributes.code.instructions.DCmpG;
import net.runelite.asm.attributes.code.instructions.DCmpL;
import net.runelite.asm.attributes.code.instructions.DConst_0;
import net.runelite.asm.attributes.code.instructions.DConst_1;
import net.runelite.asm.attributes.code.instructions.DDiv;
import net.runelite.asm.attributes.code.instructions.DLoad;
import net.runelite.asm.attributes.code.instructions.DLoad_0;
import net.runelite.asm.attributes.code.instructions.DLoad_1;
import net.runelite.asm.attributes.code.instructions.DLoad_2;
import net.runelite.asm.attributes.code.instructions.DLoad_3;
import net.runelite.asm.attributes.code.instructions.DMul;
import net.runelite.asm.attributes.code.instructions.DNeg;
import net.runelite.asm.attributes.code.instructions.DRem;
import net.runelite.asm.attributes.code.instructions.DStore;
import net.runelite.asm.attributes.code.instructions.DStore_0;
import net.runelite.asm.attributes.code.instructions.DStore_1;
import net.runelite.asm.attributes.code.instructions.DStore_2;
import net.runelite.asm.attributes.code.instructions.DStore_3;
import net.runelite.asm.attributes.code.instructions.DSub;
import net.runelite.asm.attributes.code.instructions.Dup;
import net.runelite.asm.attributes.code.instructions.Dup2;
import net.runelite.asm.attributes.code.instructions.Dup2_X1;
import net.runelite.asm.attributes.code.instructions.Dup2_X2;
import net.runelite.asm.attributes.code.instructions.Dup_X1;
import net.runelite.asm.attributes.code.instructions.Dup_X2;
import net.runelite.asm.attributes.code.instructions.F2D;
import net.runelite.asm.attributes.code.instructions.F2I;
import net.runelite.asm.attributes.code.instructions.F2L;
import net.runelite.asm.attributes.code.instructions.FALoad;
import net.runelite.asm.attributes.code.instructions.FAStore;
import net.runelite.asm.attributes.code.instructions.FAdd;
import net.runelite.asm.attributes.code.instructions.FCmpG;
import net.runelite.asm.attributes.code.instructions.FCmpL;
import net.runelite.asm.attributes.code.instructions.FConst_0;
import net.runelite.asm.attributes.code.instructions.FConst_1;
import net.runelite.asm.attributes.code.instructions.FConst_2;
import net.runelite.asm.attributes.code.instructions.FDiv;
import net.runelite.asm.attributes.code.instructions.FLoad;
import net.runelite.asm.attributes.code.instructions.FLoad_0;
import net.runelite.asm.attributes.code.instructions.FLoad_1;
import net.runelite.asm.attributes.code.instructions.FLoad_2;
import net.runelite.asm.attributes.code.instructions.FLoad_3;
import net.runelite.asm.attributes.code.instructions.FMul;
import net.runelite.asm.attributes.code.instructions.FNeg;
import net.runelite.asm.attributes.code.instructions.FRem;
import net.runelite.asm.attributes.code.instructions.FStore;
import net.runelite.asm.attributes.code.instructions.FStore_0;
import net.runelite.asm.attributes.code.instructions.FStore_1;
import net.runelite.asm.attributes.code.instructions.FStore_2;
import net.runelite.asm.attributes.code.instructions.FStore_3;
import net.runelite.asm.attributes.code.instructions.FSub;
import net.runelite.asm.attributes.code.instructions.GetField;
import net.runelite.asm.attributes.code.instructions.GetStatic;
import net.runelite.asm.attributes.code.instructions.Goto;
import net.runelite.asm.attributes.code.instructions.GotoW;
import net.runelite.asm.attributes.code.instructions.I2B;
import net.runelite.asm.attributes.code.instructions.I2C;
import net.runelite.asm.attributes.code.instructions.I2D;
import net.runelite.asm.attributes.code.instructions.I2F;
import net.runelite.asm.attributes.code.instructions.I2L;
import net.runelite.asm.attributes.code.instructions.I2S;
import net.runelite.asm.attributes.code.instructions.IALoad;
import net.runelite.asm.attributes.code.instructions.IAStore;
import net.runelite.asm.attributes.code.instructions.IAdd;
import net.runelite.asm.attributes.code.instructions.IAnd;
import net.runelite.asm.attributes.code.instructions.IConst_0;
import net.runelite.asm.attributes.code.instructions.IConst_1;
import net.runelite.asm.attributes.code.instructions.IConst_2;
import net.runelite.asm.attributes.code.instructions.IConst_3;
import net.runelite.asm.attributes.code.instructions.IConst_4;
import net.runelite.asm.attributes.code.instructions.IConst_5;
import net.runelite.asm.attributes.code.instructions.IConst_M1;
import net.runelite.asm.attributes.code.instructions.IDiv;
import net.runelite.asm.attributes.code.instructions.IInc;
import net.runelite.asm.attributes.code.instructions.ILoad;
import net.runelite.asm.attributes.code.instructions.ILoad_0;
import net.runelite.asm.attributes.code.instructions.ILoad_1;
import net.runelite.asm.attributes.code.instructions.ILoad_2;
import net.runelite.asm.attributes.code.instructions.ILoad_3;
import net.runelite.asm.attributes.code.instructions.IMul;
import net.runelite.asm.attributes.code.instructions.INeg;
import net.runelite.asm.attributes.code.instructions.IOr;
import net.runelite.asm.attributes.code.instructions.IRem;
import net.runelite.asm.attributes.code.instructions.IShL;
import net.runelite.asm.attributes.code.instructions.IShR;
import net.runelite.asm.attributes.code.instructions.IStore;
import net.runelite.asm.attributes.code.instructions.IStore_0;
import net.runelite.asm.attributes.code.instructions.IStore_1;
import net.runelite.asm.attributes.code.instructions.IStore_2;
import net.runelite.asm.attributes.code.instructions.IStore_3;
import net.runelite.asm.attributes.code.instructions.ISub;
import net.runelite.asm.attributes.code.instructions.IUShR;
import net.runelite.asm.attributes.code.instructions.IXor;
import net.runelite.asm.attributes.code.instructions.IfACmpEq;
import net.runelite.asm.attributes.code.instructions.IfACmpNe;
import net.runelite.asm.attributes.code.instructions.IfICmpEq;
import net.runelite.asm.attributes.code.instructions.IfCmpGe;
import net.runelite.asm.attributes.code.instructions.IfCmpGt;
import net.runelite.asm.attributes.code.instructions.IfCmpLe;
import net.runelite.asm.attributes.code.instructions.IfCmpLt;
import net.runelite.asm.attributes.code.instructions.IfICmpNe;
import net.runelite.asm.attributes.code.instructions.IfEq;
import net.runelite.asm.attributes.code.instructions.IfGe;
import net.runelite.asm.attributes.code.instructions.IfGt;
import net.runelite.asm.attributes.code.instructions.IfLe;
import net.runelite.asm.attributes.code.instructions.IfLt;
import net.runelite.asm.attributes.code.instructions.IfNe;
import net.runelite.asm.attributes.code.instructions.IfNonNull;
import net.runelite.asm.attributes.code.instructions.IfNull;
import net.runelite.asm.attributes.code.instructions.InstanceOf;
import net.runelite.asm.attributes.code.instructions.InvokeInterface;
import net.runelite.asm.attributes.code.instructions.InvokeSpecial;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.InvokeVirtual;
import net.runelite.asm.attributes.code.instructions.L2D;
import net.runelite.asm.attributes.code.instructions.L2F;
import net.runelite.asm.attributes.code.instructions.L2I;
import net.runelite.asm.attributes.code.instructions.LALoad;
import net.runelite.asm.attributes.code.instructions.LAStore;
import net.runelite.asm.attributes.code.instructions.LAdd;
import net.runelite.asm.attributes.code.instructions.LAnd;
import net.runelite.asm.attributes.code.instructions.LCmp;
import net.runelite.asm.attributes.code.instructions.LConst_0;
import net.runelite.asm.attributes.code.instructions.LConst_1;
import net.runelite.asm.attributes.code.instructions.LDC2_W;
import net.runelite.asm.attributes.code.instructions.LDC_W;
import net.runelite.asm.attributes.code.instructions.LDiv;
import net.runelite.asm.attributes.code.instructions.LLoad;
import net.runelite.asm.attributes.code.instructions.LLoad_0;
import net.runelite.asm.attributes.code.instructions.LLoad_1;
import net.runelite.asm.attributes.code.instructions.LLoad_2;
import net.runelite.asm.attributes.code.instructions.LLoad_3;
import net.runelite.asm.attributes.code.instructions.LMul;
import net.runelite.asm.attributes.code.instructions.LNeg;
import net.runelite.asm.attributes.code.instructions.LOr;
import net.runelite.asm.attributes.code.instructions.LRem;
import net.runelite.asm.attributes.code.instructions.LShL;
import net.runelite.asm.attributes.code.instructions.LShR;
import net.runelite.asm.attributes.code.instructions.LStore;
import net.runelite.asm.attributes.code.instructions.LStore_0;
import net.runelite.asm.attributes.code.instructions.LStore_1;
import net.runelite.asm.attributes.code.instructions.LStore_2;
import net.runelite.asm.attributes.code.instructions.LStore_3;
import net.runelite.asm.attributes.code.instructions.LSub;
import net.runelite.asm.attributes.code.instructions.LUShR;
import net.runelite.asm.attributes.code.instructions.LXor;
import net.runelite.asm.attributes.code.instructions.LookupSwitch;
import net.runelite.asm.attributes.code.instructions.MonitorEnter;
import net.runelite.asm.attributes.code.instructions.MonitorExit;
import net.runelite.asm.attributes.code.instructions.MultiANewArray;
import net.runelite.asm.attributes.code.instructions.NOP;
import net.runelite.asm.attributes.code.instructions.New;
import net.runelite.asm.attributes.code.instructions.NewArray;
import net.runelite.asm.attributes.code.instructions.Pop;
import net.runelite.asm.attributes.code.instructions.Pop2;
import net.runelite.asm.attributes.code.instructions.PutField;
import net.runelite.asm.attributes.code.instructions.PutStatic;
import net.runelite.asm.attributes.code.instructions.Return;
import net.runelite.asm.attributes.code.instructions.SALoad;
import net.runelite.asm.attributes.code.instructions.SAStore;
import net.runelite.asm.attributes.code.instructions.SiPush;
import net.runelite.asm.attributes.code.instructions.Swap;
import net.runelite.asm.attributes.code.instructions.TableSwitch;
import net.runelite.asm.attributes.code.instructions.VReturn;
import net.runelite.asm.attributes.code.instructions.Wide;

public enum InstructionType
{
	NOP(0x00, "nop", NOP.class),
	ACONST_NULL(0x01, "aconst_null", AConstNull.class),
	ICONST_M1(0x02, "iconst_m1", IConst_M1.class),
	ICONST_0(0x03, "iconst_0", IConst_0.class),
	ICONST_1(0x04, "iconst_1", IConst_1.class),
	ICONST_2(0x05, "iconst_2", IConst_2.class),
	ICONST_3(0x06, "iconst_3", IConst_3.class),
	ICONST_4(0x07, "iconst_4", IConst_4.class),
	ICONST_5(0x08, "iconst_5", IConst_5.class),
	LCONST_0(0x09, "lconst_0", LConst_0.class),
	LCONST_1(0x0a, "lconst_1", LConst_1.class),
	FCONST_0(0x0b, "fconst_0", FConst_0.class),
	FCONST_1(0x0c, "fconst_1", FConst_1.class),
	FCONST_2(0x0d, "fconst_2", FConst_2.class),
	DCONST_0(0x0e, "dconst_0", DConst_0.class),
	DCONST_1(0x0f, "dconst_1", DConst_1.class),
	BIPUSH(0x10, "bipush", BiPush.class),
	SIPUSH(0x11, "sipush", SiPush.class),
	LDC(0x12, "ldc_w", LDC_W.class),
	LDC_W(0x13, "ldc_w", LDC_W.class),
	LDC2_W(0x14, "ldc2_w", LDC2_W.class),
	ILOAD(0x15, "iload", ILoad.class),
	LLOAD(0x16, "lload", LLoad.class),
	FLOAD(0x17, "fload", FLoad.class),
	DLOAD(0x18, "dload", DLoad.class),
	ALOAD(0x19, "aload", ALoad.class),
	ILOAD_0(0x1a, "iload_0", ILoad_0.class),
	ILOAD_1(0x1b, "iload_1", ILoad_1.class),
	ILOAD_2(0x1c, "iload_2", ILoad_2.class),
	ILOAD_3(0x1d, "iload_3", ILoad_3.class),
	LLOAD_0(0x1e, "lload_0", LLoad_0.class),
	LLOAD_1(0x1f, "lload_1", LLoad_1.class),
	LLOAD_2(0x20, "lload_2", LLoad_2.class),
	LLOAD_3(0x21, "lload_3", LLoad_3.class),
	FLOAD_0(0x22, "fload_0", FLoad_0.class),
	FLOAD_1(0x23, "fload_1", FLoad_1.class),
	FLOAD_2(0x24, "fload_2", FLoad_2.class),
	FLOAD_3(0x25, "fload_3", FLoad_3.class),
	DLOAD_0(0x26, "dload_0", DLoad_0.class),
	DLOAD_1(0x27, "dload_1", DLoad_1.class),
	DLOAD_2(0x28, "dload_2", DLoad_2.class),
	DLOAD_3(0x29, "dload_3", DLoad_3.class),
	ALOAD_0(0x2a, "aload_0", ALoad_0.class),
	ALOAD_1(0x2b, "aload_1", ALoad_1.class),
	ALOAD_2(0x2c, "aload_2", ALoad_2.class),
	ALOAD_3(0x2d, "aload_3", ALoad_3.class),
	IALOAD(0x2e, "iaload", IALoad.class),
	LALOAD(0x2f, "laload", LALoad.class),
	FALOAD(0x30, "faload", FALoad.class),
	DALOAD(0x31, "daload", DALoad.class),
	AALOAD(0x32, "aaload", AALoad.class),
	BALOAD(0x33, "baload", BALoad.class),
	CALOAD(0x34, "caload", CALoad.class),
	SALOAD(0x35, "saload", SALoad.class),
	ISTORE(0x36, "istore", IStore.class),
	LSTORE(0x37, "lstore", LStore.class),
	FSTORE(0x38, "fstore", FStore.class),
	DSTORE(0x39, "dstore", DStore.class),
	ASTORE(0x3a, "astore", AStore.class),
	ISTORE_0(0x3b, "istore_0", IStore_0.class),
	ISTORE_1(0x3c, "istore_1", IStore_1.class),
	ISTORE_2(0x3d, "istore_2", IStore_2.class),
	ISTORE_3(0x3e, "istore_3", IStore_3.class),
	LSTORE_0(0x3f, "lstore_0", LStore_0.class),
	LSTORE_1(0x40, "lstore_1", LStore_1.class),
	LSTORE_2(0x41, "lstore_2", LStore_2.class),
	LSTORE_3(0x42, "lstore_3", LStore_3.class),
	FSTORE_0(0x43, "fstore_0", FStore_0.class),
	FSTORE_1(0x44, "fstore_1", FStore_1.class),
	FSTORE_2(0x45, "fstore_2", FStore_2.class),
	FSTORE_3(0x46, "fstore_3", FStore_3.class),
	DST0RE_0(0x47, "dstore_0", DStore_0.class),
	DSTORE_1(0x48, "dstore_1", DStore_1.class),
	DSTORE_2(0x49, "dstore_2", DStore_2.class),
	DSTORE_3(0x4a, "dstore_3", DStore_3.class),
	ASTORE_0(0x4b, "astore_0", AStore_0.class),
	ASTORE_1(0x4c, "astore_1", AStore_1.class),
	ASTORE_2(0x4d, "astore_2", AStore_2.class),
	ASTORE_3(0x4e, "astore_3", AStore_3.class),
	IASTORE(0x4f, "iastore", IAStore.class),
	LASTORE(0x50, "lastore", LAStore.class),
	FASTORE(0x51, "fastore", FAStore.class),
	DASTORE(0x52, "dastore", DAStore.class),
	AASTORE(0x53, "aastore", AAStore.class),
	BASTORE(0x54, "bastore", BAStore.class),
	CASTORE(0x55, "castore", CAStore.class),
	SASTORE(0x56, "sastore", SAStore.class),
	POP(0x57, "pop", Pop.class),
	POP2(0x58, "pop2", Pop2.class),
	DUP(0x59, "dup", Dup.class),
	DUP_X1(0x5a, "dup_x1", Dup_X1.class),
	DUP_X2(0x5b, "dup_x2", Dup_X2.class),
	DUP2(0x5c, "dup2", Dup2.class),
	DUP2_X1(0x5d, "dup2_x1", Dup2_X1.class),
	DUP2_X2(0x5e, "dup2_x2", Dup2_X2.class),
	SWAP(0x5f, "swap", Swap.class),
	IADD(0x60, "iadd", IAdd.class),
	LADD(0x61, "ladd", LAdd.class),
	FADD(0x62, "fadd", FAdd.class),
	DADD(0x63, "dadd", DAdd.class),
	ISUB(0x64, "isub", ISub.class),
	LSUB(0x65, "lsub", LSub.class),
	FSUB(0x66, "fsub", FSub.class),
	DSUB(0x67, "dsub", DSub.class),
	IMUL(0x68, "imul", IMul.class),
	LMUL(0x69, "lmul", LMul.class),
	FMUL(0x6a, "fmul", FMul.class),
	DMUL(0x6b, "dmul", DMul.class),
	IDIV(0x6c, "idiv", IDiv.class),
	LDIV(0x6d, "ldiv", LDiv.class),
	FDIV(0x6e, "fdiv", FDiv.class),
	DDIV(0x6f, "ddiv", DDiv.class),
	IREM(0x70, "irem", IRem.class),
	LREM(0x71, "lrem", LRem.class),
	FREM(0x72, "frem", FRem.class),
	DREM(0x73, "drem", DRem.class),
	INEG(0x74, "ineg", INeg.class),
	LNEG(0x75, "lneg", LNeg.class),
	FNEG(0x76, "fneg", FNeg.class),
	DNEG(0x77, "dneg", DNeg.class),
	ISHL(0x78, "ishl", IShL.class),
	LSHL(0x79, "lshl", LShL.class),
	ISHR(0x7a, "ishr", IShR.class),
	LSHR(0x7b, "lshr", LShR.class),
	IUSHR(0x7c, "iushr", IUShR.class),
	LUSHR(0x7d, "lushr", LUShR.class),
	IAND(0x7e, "iand", IAnd.class),
	LAND(0x7f, "land", LAnd.class),
	IOR(0x80, "ior", IOr.class),
	LOR(0x81, "lor", LOr.class),
	IXOR(0x82, "ixor", IXor.class),
	LXOR(0x83, "lxor", LXor.class),
	IINC(0x84, "iinc", IInc.class),
	I2L(0x85, "i2l", I2L.class),
	I2F(0x86, "i2f", I2F.class),
	I2D(0x87, "i2d", I2D.class),
	L2I(0x88, "l2i", L2I.class),
	L2F(0x89, "l2f", L2F.class),
	L2D(0x8a, "l2d", L2D.class),
	F2I(0x8b, "f2i", F2I.class),
	F2L(0x8c, "f2l", F2L.class),
	F2D(0x8d, "f2d", F2D.class),
	D2I(0x8e, "d2i", D2I.class),
	D2L(0x8f, "d2l", D2L.class),
	D2F(0x90, "d2f", D2F.class),
	I2B(0x91, "i2b", I2B.class),
	I2C(0x92, "i2c", I2C.class),
	I2S(0x93, "i2s", I2S.class),
	LCMP(0x94, "lcmp", LCmp.class),
	FCMPL(0x95, "fcmpl", FCmpL.class),
	FCMPG(0x96, "fcmpg", FCmpG.class),
	DCMPL(0x97, "dcmpl", DCmpL.class),
	DCMPG(0x98, "dcmpg", DCmpG.class),
	IFEQ(0x99, "ifeq", IfEq.class),
	IFNE(0x9a, "ifne", IfNe.class),
	IFLT(0x9b, "iflt", IfLt.class),
	IFGE(0x9c, "ifge", IfGe.class),
	IFGT(0x9d, "ifgt", IfGt.class),
	IFLE(0x9e, "ifle", IfLe.class),
	IF_ICMPEQ(0x9f, "if_icmpeq", IfICmpEq.class),
	IF_ICMPNE(0xa0, "if_icmpne", IfICmpNe.class),
	IF_ICMPLT(0xa1, "if_cmplt", IfCmpLt.class),
	IF_ICMPGE(0xa2, "if_icmpge", IfCmpGe.class),
	IF_ICMPGT(0xa3, "if_icmpgt", IfCmpGt.class),
	IF_ICMPLE(0xa4, "if_icmple", IfCmpLe.class),
	IF_ACMPEQ(0xa5, "if_acmpeq", IfACmpEq.class),
	IF_ACMPNE(0xa6, "if_acmpne", IfACmpNe.class),
	GOTO(0xa7, "goto", Goto.class),
	TABLESWITCH(0xaa, "tableswitch", TableSwitch.class),
	LOOKUPSWITCH(0xab, "lookupswitch", LookupSwitch.class),
	IRETURN(0xac, "ireturn", Return.class),
	LRETURN(0xad, "lreturn", Return.class),
	FRETURN(0xae, "freturn", Return.class),
	DRETURN(0xaf, "dreturn", Return.class),
	ARETURN(0xb0, "areturn", Return.class),
	RETURN(0xb1, "return", VReturn.class),
	GETSTATIC(0xb2, "getstatic", GetStatic.class),
	PUTSTATIC(0xb3, "putstatic", PutStatic.class),
	GETFIELD(0xb4, "getfield", GetField.class),
	PUTFIELD(0xb5, "putfield", PutField.class),
	INVOKEVIRTUAL(0xb6, "invokevirtual", InvokeVirtual.class),
	INVOKESPECIAL(0xb7, "invokespecial", InvokeSpecial.class),
	INVOKESTATIC(0xb8, "invokestatic", InvokeStatic.class),
	INVOKEINTERFACE(0xb9, "invokeinterface", InvokeInterface.class),
	NEW(0xbb, "new", New.class),
	NEWARRAY(0xbc, "newarray", NewArray.class),
	ANEWARRAY(0xbd, "anewarray", ANewArray.class),
	ARRAYLENGTH(0xbe, "arraylength", ArrayLength.class),
	ATHROW(0xbf, "athrow", AThrow.class),
	CHECKCAST(0xc0, "checkcast", CheckCast.class),
	INSTANCEOf(0xc1, "instanceof", InstanceOf.class),
	MONITORENTER(0xc2, "monitorenter", MonitorEnter.class),
	MONITOREXIT(0xc3, "monitorexit", MonitorExit.class),
	WIDE(0xc4, "wide", Wide.class),
	MULTIANEWARRAY(0xc5, "multianewarray", MultiANewArray.class),
	IFNULL(0xc6, "ifnull", IfNull.class),
	IFNONNULL(0xc7, "ifnonnull", IfNonNull.class),
	GOTO_W(0xc8, "goto_w", GotoW.class);

	private byte code;
	private String name;
	private Class<? extends Instruction> clazz;

	InstructionType(int op, String name, Class<? extends Instruction> clazz)
	{
		this.code = (byte) op;
		this.name = name;
		this.clazz = clazz;
	}

	public byte getCode()
	{
		return code;
	}

	public String getName()
	{
		return name;
	}

	public Class<? extends Instruction> getInstructionClass()
	{
		return clazz;
	}

	public static InstructionType findInstructionFromCode(byte code)
	{
		for (InstructionType t : InstructionType.values())
			if (t.getCode() == code)
				return t;
		return null;
	}
}
