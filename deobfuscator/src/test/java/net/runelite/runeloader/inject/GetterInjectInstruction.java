package net.runelite.runeloader.inject;

public class GetterInjectInstruction {
   private final String className;
   private final String getterMethodDesc;
   private final String getterName;
   private final String getterClassName;
   private final String getterFieldName;
   private final Integer multiplier;
   private final boolean staticField;

   public GetterInjectInstruction(String var1, String var2, String var3, String var4, String var5, Integer var6, boolean var7) {
      this.className = var1;
      this.getterMethodDesc = "()" + var3;
      this.getterName = var2;
      this.getterClassName = var4;
      this.getterFieldName = var5;
      this.multiplier = var6;
      this.staticField = var7;
   }

	@Override
	public String toString()
	{
		return "GetterInjectInstruction{" + "className=" + className + ", getterMethodDesc=" + getterMethodDesc + ", getterName=" + getterName + ", getterClassName=" + getterClassName + ", getterFieldName=" + getterFieldName + ", multiplier=" + multiplier + ", staticField=" + staticField + '}';
	}

   public String getClassName() {
      return this.className;
   }

   public String getGetterMethodDesc() {
      return this.getterMethodDesc;
   }

   public String getGetterName() {
      return this.getterName;
   }

   public String getGetterClassName() {
      return this.getterClassName;
   }

   public String getGetterFieldName() {
      return this.getterFieldName;
   }

   public Integer getMultiplier() {
      return this.multiplier;
   }

   public boolean isStaticField() {
      return this.staticField;
   }
//
//   public boolean valid(ClassNode var1) {
//      return var1.name.equalsIgnoreCase(this.className);
//   }
//
//   private FieldNode get(qelKbskphK[] var1) {
//      qelKbskphK[] var5 = var1;
//      int var4 = var1.length;
//
//      for(int var3 = 0; var3 < var4; ++var3) {
//         qelKbskphK var2 = var5[var3];
//         ClassNode var6 = var2.KxdZMCzVTn();
//         if(var6.name.equalsIgnoreCase(this.getterClassName)) {
//            Iterator var8 = var6.fields.iterator();
//
//            while(var8.hasNext()) {
//               FieldNode var7 = (FieldNode)var8.next();
//               if(var7.name.equalsIgnoreCase(this.getterFieldName)) {
//                  return var7;
//               }
//            }
//         }
//      }
//
//      return null;
//   }
//
//   public void inject(ClassNode var1, qelKbskphK[] var2) {
//      String var3 = this.getGetterMethodDesc().substring(2);
//      MethodNode var4 = new MethodNode(1, this.getGetterName(), this.getGetterMethodDesc(), (String)null, (String[])null);
//      if(!this.isStaticField()) {
//         var4.instructions.add(new VarInsnNode(25, 0));
//      }
//
//      int var5 = this.isStaticField()?178:180;
//      var4.instructions.add(new FieldInsnNode(var5, this.getterClassName, this.getterFieldName, this.get(var2).desc));
//      if(this.getMultiplier() != null) {
//         var4.instructions.add(new LdcInsnNode(this.getMultiplier()));
//         var4.instructions.add(new InsnNode(104));
//      }
//
//      var4.instructions.add(new InsnNode(getReturn(Type.getReturnType(var3).getSort())));
//      var1.methods.add(var4);
//   }
//
//   public static int getReturn(int var0) {
//      return var0 == 0?177:(var0 >= 1 && var0 <= 5?172:(var0 == 6?174:(var0 == 7?173:(var0 == 8?175:176))));
//   }
//
//   private int getReturnOpcode(String var1) {
//      var1 = var1.substring(var1.indexOf(")") + 1);
//      if(var1.length() > 1) {
//         return 176;
//      } else {
//         char var2 = var1.charAt(0);
//         switch(var2) {
//         case 'B':
//         case 'C':
//         case 'I':
//         case 'S':
//         case 'Z':
//            return 172;
//         case 'D':
//            return 175;
//         case 'E':
//         case 'G':
//         case 'H':
//         case 'K':
//         case 'L':
//         case 'M':
//         case 'N':
//         case 'O':
//         case 'P':
//         case 'Q':
//         case 'R':
//         case 'T':
//         case 'U':
//         case 'V':
//         case 'W':
//         case 'X':
//         case 'Y':
//         default:
//            throw new RuntimeException("bad_return");
//         case 'F':
//            return 174;
//         case 'J':
//            return 173;
//         }
//      }
//   }
}
