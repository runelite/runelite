import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public class class0 extends Node {
   @ObfuscatedName("z")
   boolean field0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1693105577
   )
   int field1;
   @ObfuscatedName("t")
   Widget field2;
   @ObfuscatedName("m")
   Widget field3;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1272589483
   )
   int field4;
   @ObfuscatedName("s")
   Object[] field5;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1820840383
   )
   int field6;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1991295003
   )
   int field8;
   @ObfuscatedName("h")
   String field9;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1586671601
   )
   int field10;
   @ObfuscatedName("me")
   static byte field11;
   @ObfuscatedName("ny")
   @ObfuscatedGetter(
      intValue = -324861195
   )
   static int field12;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -498617303
   )
   int field13;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "695622917"
   )
   public static void method0(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class52.field1112 = var1.method2668();
      class79.field1419 = new int[class52.field1112];
      XClanMember.field612 = new int[class52.field1112];
      class79.field1420 = new int[class52.field1112];
      class8.field129 = new int[class52.field1112];
      class220.field3211 = new byte[class52.field1112][];
      var1.offset = var0.length - 7 - class52.field1112 * 8;
      class79.field1422 = var1.method2668();
      class79.field1418 = var1.method2668();
      int var2 = (var1.method2481() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class52.field1112; ++var3) {
         class79.field1419[var3] = var1.method2668();
      }

      for(var3 = 0; var3 < class52.field1112; ++var3) {
         XClanMember.field612[var3] = var1.method2668();
      }

      for(var3 = 0; var3 < class52.field1112; ++var3) {
         class79.field1420[var3] = var1.method2668();
      }

      for(var3 = 0; var3 < class52.field1112; ++var3) {
         class8.field129[var3] = var1.method2668();
      }

      var1.offset = var0.length - 7 - class52.field1112 * 8 - 3 * (var2 - 1);
      class117.field2002 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class117.field2002[var3] = var1.method2485();
         if(class117.field2002[var3] == 0) {
            class117.field2002[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class52.field1112; ++var3) {
         int var4 = class79.field1420[var3];
         int var5 = class8.field129[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         class220.field3211[var3] = var7;
         int var8 = var1.method2481();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.method2601();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var10 * var4 + var9] = var1.method2601();
               }
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass170;IIB)[LModIcon;",
      garbageValue = "71"
   )
   static ModIcon[] method1(class170 var0, int var1, int var2) {
      if(!class35.method729(var0, var1, var2)) {
         return null;
      } else {
         ModIcon[] var4 = new ModIcon[class52.field1112];

         for(int var5 = 0; var5 < class52.field1112; ++var5) {
            ModIcon var6 = var4[var5] = new ModIcon();
            var6.width = class79.field1422;
            var6.originalHeight = class79.field1418;
            var6.offsetX = class79.field1419[var5];
            var6.offsetY = XClanMember.field612[var5];
            var6.originalWidth = class79.field1420[var5];
            var6.height = class8.field129[var5];
            var6.palette = class117.field2002;
            var6.pixels = class220.field3211[var5];
         }

         class23.method571();
         return var4;
      }
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-516354141"
   )
   static void method2() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         int var2 = Client.menuTypes[var0];
         boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
         if(var1) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var3 = var0; var3 < Client.menuOptionCount - 1; ++var3) {
                  Client.menuOptions[var3] = Client.menuOptions[1 + var3];
                  Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
                  Client.menuTypes[var3] = Client.menuTypes[1 + var3];
                  Client.menuIdentifiers[var3] = Client.menuIdentifiers[var3 + 1];
                  Client.menuActionParams0[var3] = Client.menuActionParams0[var3 + 1];
                  Client.menuActionParams1[var3] = Client.menuActionParams1[1 + var3];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "187173865"
   )
   static boolean method3(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class141.field2176.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var10 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var10.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var5) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Object var3 = class135.method2849(class141.field2172, var2, new Object[]{(new URL(class141.field2172.getCodeBase(), var0)).toString()});
            return null != var3;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class141.field2172.getAppletContext().showDocument(new URL(class141.field2172.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class135.method2844(class141.field2172, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class141.field2172.getAppletContext().showDocument(new URL(class141.field2172.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }
}
