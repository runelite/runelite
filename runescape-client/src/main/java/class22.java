import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public class class22 extends class28 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -353483143
   )
   static int field348;
   @ObfuscatedName("fy")
   @ObfuscatedGetter(
      intValue = 411265
   )
   @Export("baseX")
   static int baseX;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lfz;Lfz;B)V",
      garbageValue = "-72"
   )
   void method167(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field521.field515) {
         throw new IllegalStateException("");
      } else {
         super.field419 = var2.readUnsignedByte();
         super.field415 = var2.readUnsignedByte();
         super.field423 = var2.readUnsignedShort();
         super.field416 = var2.readUnsignedShort();
         super.field420 = var2.readUnsignedShort();
         super.field418 = var2.readUnsignedShort();
         super.field415 = Math.min(super.field415, 4);
         super.field421 = new short[1][64][64];
         super.field417 = new short[super.field415][64][64];
         super.field422 = new byte[super.field415][64][64];
         super.field424 = new byte[super.field415][64][64];
         super.field425 = new class31[super.field415][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field511.field507) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field420 && var5 == super.field418) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method239(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public int hashCode() {
      return super.field420 | super.field418 << 8;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return var2.field420 == super.field420 && var2.field418 == super.field418;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "107"
   )
   static void method168() {
      if(Signlink.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
         KeyFocusListener.field669[186] = 57;
         KeyFocusListener.field669[187] = 27;
         KeyFocusListener.field669[188] = 71;
         KeyFocusListener.field669[189] = 26;
         KeyFocusListener.field669[190] = 72;
         KeyFocusListener.field669[191] = 73;
         KeyFocusListener.field669[192] = 58;
         KeyFocusListener.field669[219] = 42;
         KeyFocusListener.field669[220] = 74;
         KeyFocusListener.field669[221] = 43;
         KeyFocusListener.field669[222] = 59;
         KeyFocusListener.field669[223] = 28;
      } else {
         KeyFocusListener.field669[44] = 71;
         KeyFocusListener.field669[45] = 26;
         KeyFocusListener.field669[46] = 72;
         KeyFocusListener.field669[47] = 73;
         KeyFocusListener.field669[59] = 57;
         KeyFocusListener.field669[61] = 27;
         KeyFocusListener.field669[91] = 42;
         KeyFocusListener.field669[92] = 74;
         KeyFocusListener.field669[93] = 43;
         KeyFocusListener.field669[192] = 28;
         KeyFocusListener.field669[222] = 58;
         KeyFocusListener.field669[520] = 59;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILfr;Lih;I)V",
      garbageValue = "980131871"
   )
   static void method174(int var0, IndexFile var1, IndexData var2) {
      byte[] var3 = null;
      Deque var4 = class236.field3229;
      synchronized(class236.field3229) {
         for(FileSystem var5 = (FileSystem)class236.field3229.getFront(); var5 != null; var5 = (FileSystem)class236.field3229.getNext()) {
            if(var5.hash == (long)var0 && var1 == var5.index && var5.field3200 == 0) {
               var3 = var5.field3197;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method4298(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method3060(var0);
         var2.method4298(var1, var0, var8, true);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIII)Z",
      garbageValue = "-1953875368"
   )
   static final boolean method173(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label70:
      while(true) {
         int var6 = var4.getUSmart();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.getUSmart();
               if(var9 == 0) {
                  continue label70;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.readUnsignedByte() >> 2;
               int var13 = var11 + var1;
               int var14 = var10 + var2;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  ObjectComposition var15 = CollisionData.getObjectDefinition(var5);
                  if(var12 != 22 || !Client.lowMemory || var15.field3454 != 0 || var15.interactType == 1 || var15.field3473) {
                     if(!var15.method4604()) {
                        ++Client.field983;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.getUSmart();
            if(var9 == 0) {
               break;
            }

            var4.readUnsignedByte();
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/CharSequence;III)Ljava/lang/String;",
      garbageValue = "1225516605"
   )
   public static String method164(CharSequence[] var0, int var1, int var2) {
      if(var2 == 0) {
         return "";
      } else if(var2 == 1) {
         CharSequence var3 = var0[var1];
         return var3 == null?"null":var3.toString();
      } else {
         int var8 = var2 + var1;
         int var4 = 0;

         for(int var5 = var1; var5 < var8; ++var5) {
            CharSequence var6 = var0[var5];
            if(var6 == null) {
               var4 += 4;
            } else {
               var4 += var6.length();
            }
         }

         StringBuilder var9 = new StringBuilder(var4);

         for(int var10 = var1; var10 < var8; ++var10) {
            CharSequence var7 = var0[var10];
            if(var7 == null) {
               var9.append("null");
            } else {
               var9.append(var7);
            }
         }

         return var9.toString();
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BB)Lct;",
      garbageValue = "11"
   )
   static Script method172(byte[] var0) {
      Script var1 = new Script();
      Buffer var2 = new Buffer(var0);
      var2.offset = var2.payload.length - 2;
      int var3 = var2.readUnsignedShort();
      int var4 = var2.payload.length - 2 - var3 - 12;
      var2.offset = var4;
      int var5 = var2.readInt();
      var1.localIntCount = var2.readUnsignedShort();
      var1.localStringCount = var2.readUnsignedShort();
      var1.intStackCount = var2.readUnsignedShort();
      var1.stringStackCount = var2.readUnsignedShort();
      int var6 = var2.readUnsignedByte();
      int var7;
      int var8;
      if(var6 > 0) {
         var1.switches = var1.method1882(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.readUnsignedShort();
            IterableHashTable var9 = new IterableHashTable(class48.method707(var8));
            var1.switches[var7] = var9;

            while(var8-- > 0) {
               int var10 = var2.readInt();
               int var11 = var2.readInt();
               var9.put(new IntegerNode(var11), (long)var10);
            }
         }
      }

      var2.offset = 0;
      var2.getNullString();
      var1.instructions = new int[var5];
      var1.intOperands = new int[var5];
      var1.stringOperands = new String[var5];

      for(var7 = 0; var2.offset < var4; var1.instructions[var7++] = var8) {
         var8 = var2.readUnsignedShort();
         if(var8 == 3) {
            var1.stringOperands[var7] = var2.readString();
         } else if(var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
            var1.intOperands[var7] = var2.readInt();
         } else {
            var1.intOperands[var7] = var2.readUnsignedByte();
         }
      }

      return var1;
   }
}
