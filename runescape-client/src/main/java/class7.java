import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class7 {
   @ObfuscatedName("h")
   public static boolean field228;
   @ObfuscatedName("u")
   public static boolean field230;
   @ObfuscatedName("q")
   public static class11 field231;
   @ObfuscatedName("g")
   static CombatInfoList field232;
   @ObfuscatedName("km")
   static class89 field235;
   @ObfuscatedName("i")
   public static boolean field236;

   static {
      field236 = false;
      field228 = false;
      field230 = false;
      field231 = class11.field267;
      field232 = new CombatInfoList();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-620375293"
   )
   static int method25(int var0, Script var1, boolean var2) {
      int var9;
      int var10;
      if(var0 == 100) {
         class83.intStackSize -= 3;
         var9 = class83.intStack[class83.intStackSize];
         var10 = class83.intStack[class83.intStackSize + 1];
         int var5 = class83.intStack[class83.intStackSize + 2];
         if(var10 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = class261.method4792(var9);
            if(var6.children == null) {
               var6.children = new Widget[var5 + 1];
            }

            if(var6.children.length <= var5) {
               Widget[] var7 = new Widget[var5 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if(var5 > 0 && var6.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            } else {
               Widget var12 = new Widget();
               var12.type = var10;
               var12.parentId = var12.id = var6.id;
               var12.index = var5;
               var12.hasScript = true;
               var6.children[var5] = var12;
               if(var2) {
                  class83.field1311 = var12;
               } else {
                  Buffer.field2384 = var12;
               }

               class219.method4130(var6);
               return 1;
            }
         }
      } else {
         Widget var3;
         if(var0 == 101) {
            var3 = var2?class83.field1311:Buffer.field2384;
            Widget var4 = class261.method4792(var3.id);
            var4.children[var3.index] = null;
            class219.method4130(var4);
            return 1;
         } else if(var0 == 102) {
            var3 = class261.method4792(class83.intStack[--class83.intStackSize]);
            var3.children = null;
            class219.method4130(var3);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var3 = class261.method4792(class83.intStack[--class83.intStackSize]);
               if(var3 != null) {
                  class83.intStack[++class83.intStackSize - 1] = 1;
                  if(var2) {
                     class83.field1311 = var3;
                  } else {
                     Buffer.field2384 = var3;
                  }
               } else {
                  class83.intStack[++class83.intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            class83.intStackSize -= 2;
            var9 = class83.intStack[class83.intStackSize];
            var10 = class83.intStack[class83.intStackSize + 1];
            Widget var11 = class66.method1099(var9, var10);
            if(var11 != null && var10 != -1) {
               class83.intStack[++class83.intStackSize - 1] = 1;
               if(var2) {
                  class83.field1311 = var11;
               } else {
                  Buffer.field2384 = var11;
               }
            } else {
               class83.intStack[++class83.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1954809762"
   )
   public static void method26() {
      class254.field3416.reset();
      class254.field3405.reset();
      class254.field3414.reset();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1278914029"
   )
   public static void method27(int var0) {
      if(class203.field2498 != 0) {
         class203.field2500 = var0;
      } else {
         class36.field501.method3754(var0);
      }

   }

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;B)V",
      garbageValue = "-29"
   )
   static void method28(int var0, int var1, int var2, int var3, String var4) {
      Widget var5 = class66.method1099(var1, var2);
      if(var5 != null) {
         if(var5.field2634 != null) {
            class69 var6 = new class69();
            var6.field816 = var5;
            var6.field814 = var0;
            var6.field815 = var4;
            var6.field826 = var5.field2634;
            GroundObject.method2522(var6);
         }

         boolean var10 = true;
         if(var5.contentType > 0) {
            var10 = Actor.method1543(var5);
         }

         if(var10) {
            int var8 = class43.method626(var5);
            int var9 = var0 - 1;
            boolean var7 = (var8 >> var9 + 1 & 1) != 0;
            if(var7) {
               if(var0 == 1) {
                  Client.secretPacketBuffer1.putOpcode(38);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 2) {
                  Client.secretPacketBuffer1.putOpcode(60);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 3) {
                  Client.secretPacketBuffer1.putOpcode(235);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 4) {
                  Client.secretPacketBuffer1.putOpcode(42);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 5) {
                  Client.secretPacketBuffer1.putOpcode(165);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 6) {
                  Client.secretPacketBuffer1.putOpcode(221);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 7) {
                  Client.secretPacketBuffer1.putOpcode(255);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 8) {
                  Client.secretPacketBuffer1.putOpcode(229);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 9) {
                  Client.secretPacketBuffer1.putOpcode(209);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

               if(var0 == 10) {
                  Client.secretPacketBuffer1.putOpcode(164);
                  Client.secretPacketBuffer1.putInt(var1);
                  Client.secretPacketBuffer1.putShort(var2);
                  Client.secretPacketBuffer1.putShort(var3);
               }

            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "537676284"
   )
   public static void method29() {
      class280.field3745 = new CombatInfoList();
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-67079150"
   )
   static final String method30(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class82.method1610('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class82.method1610(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class82.method1610(16776960) + var1 + "</col>");
   }
}
