import java.applet.Applet;
import java.io.EOFException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("ak")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("ao")
   static class184 field911;
   @ObfuscatedName("i")
   boolean[] field912;
   @ObfuscatedName("t")
   boolean[] field913;
   @ObfuscatedName("k")
   int[] field914;
   @ObfuscatedName("h")
   @Export("messages")
   String[] messages;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 574494301254411311L
   )
   long field917;
   @ObfuscatedName("n")
   boolean field919 = false;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1954972965"
   )
   String method903(int var1) {
      return this.messages[var1];
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-123"
   )
   void method904(int var1, int var2) {
      this.field914[var1] = var2;
      if(this.field912[var1]) {
         this.field919 = true;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1081997212"
   )
   int method905(int var1) {
      return this.field914[var1];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1124023455"
   )
   void method908() {
      int var1;
      for(var1 = 0; var1 < this.field914.length; ++var1) {
         if(!this.field912[var1]) {
            this.field914[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field913[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZI)LFileOnDisk;",
      garbageValue = "-929012415"
   )
   FileOnDisk method909(boolean var1) {
      return class60.method1204("2", Client.field413.field2683, var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1322421104"
   )
   void method910() {
      FileOnDisk var1 = this.method909(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field914.length; ++var4) {
            if(this.field912[var4] && this.field914[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field913[var5] && null != this.messages[var5]) {
               var2 += 2 + class25.method615(this.messages[var5]);
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.method3010(1);
         var9.method2842(var3);

         int var6;
         for(var6 = 0; var6 < this.field914.length; ++var6) {
            if(this.field912[var6] && this.field914[var6] != -1) {
               var9.method2842(var6);
               var9.method2844(this.field914[var6]);
            }
         }

         var9.method2842(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field913[var6] && this.messages[var6] != null) {
               var9.method2842(var6);
               var9.method2893(this.messages[var6]);
            }
         }

         var1.method1468(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method1471();
         } catch (Exception var16) {
            ;
         }

      }

      this.field919 = false;
      this.field917 = method935();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "835423304"
   )
   void method912() {
      if(this.field919 && this.field917 < method935() - 60000L) {
         this.method910();
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "126"
   )
   boolean method913() {
      return this.field919;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1944761234"
   )
   void method928() {
      FileOnDisk var1 = this.method909(false);

      try {
         byte[] var2 = new byte[(int)var1.method1470()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var1.method1469(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new EOFException();
            }
         }

         Buffer var13 = new Buffer(var2);
         if(var13.payload.length - var13.offset < 1) {
            return;
         }

         int var14 = var13.readUnsignedByte();
         if(var14 < 0 || var14 > 1) {
            return;
         }

         int var15 = var13.readUnsignedShort();

         int var7;
         int var8;
         int var9;
         for(var7 = 0; var7 < var15; ++var7) {
            var8 = var13.readUnsignedShort();
            var9 = var13.readInt();
            if(this.field912[var8]) {
               this.field914[var8] = var9;
            }
         }

         var7 = var13.readUnsignedShort();

         for(var8 = 0; var8 < var7; ++var8) {
            var9 = var13.readUnsignedShort();
            String var10 = var13.readString();
            if(this.field913[var9]) {
               this.messages[var9] = var10;
            }
         }
      } catch (Exception var24) {
         ;
      } finally {
         try {
            var1.method1471();
         } catch (Exception var23) {
            ;
         }

      }

      this.field919 = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "659655799"
   )
   void method929(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field913[var1]) {
         this.field919 = true;
      }

   }

   ChatMessages() {
      this.field914 = new int[Client.field313.method3398(19)];
      this.messages = new String[Client.field313.method3398(15)];
      this.field912 = new boolean[this.field914.length];

      int var1;
      for(var1 = 0; var1 < this.field914.length; ++var1) {
         class188 var3 = (class188)class188.field2781.get((long)var1);
         class188 var2;
         if(var3 != null) {
            var2 = var3;
         } else {
            byte[] var4 = class170.field2332.getConfigData(19, var1);
            var3 = new class188();
            if(null != var4) {
               var3.method3516(new Buffer(var4));
            }

            class188.field2781.put(var3, (long)var1);
            var2 = var3;
         }

         this.field912[var1] = var2.field2780;
      }

      this.field913 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class189 var5 = class182.method3384(var1);
         this.field913[var1] = var5.field2786;
      }

      for(var1 = 0; var1 < this.field914.length; ++var1) {
         this.field914[var1] = -1;
      }

      this.method928();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "-1837939216"
   )
   public static boolean method934(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class114.field1787.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var14 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var14.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var8) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Applet var7 = class114.field1783;
            Object[] var5 = new Object[]{(new URL(class114.field1783.getCodeBase(), var0)).toString()};
            Object var13 = JSObject.getWindow(var7).call(var2, var5);
            return var13 != null;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class114.field1783.getAppletContext().showDocument(new URL(class114.field1783.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            Applet var3 = class114.field1783;
            JSObject.getWindow(var3).call("loggedout", (Object[])null);
         } catch (Throwable var12) {
            ;
         }

         try {
            class114.field1783.getAppletContext().showDocument(new URL(class114.field1783.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "95"
   )
   public static synchronized long method935() {
      long var0 = System.currentTimeMillis();
      if(var0 < class155.field2106) {
         class155.field2101 += class155.field2106 - var0;
      }

      class155.field2106 = var0;
      return var0 + class155.field2101;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "912791497"
   )
   static final void method936(int var0, int var1, int var2, int var3, int var4) {
      int var5 = Varbit.region.method1825(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var17;
      int var19;
      if(var5 != 0) {
         var6 = Varbit.region.method1786(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class148.field2025.image;
         var17 = 2048 * (103 - var2) + 24624 + 4 * var1;
         var19 = var5 >> 14 & 32767;
         ObjectComposition var20 = class196.getObjectDefinition(var19);
         if(var20.mapSceneId != -1) {
            ModIcon var14 = class32.field732[var20.mapSceneId];
            if(var14 != null) {
               int var15 = (var20.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var20.sizeY * 4 - var14.height) / 2;
               var14.method4191(var15 + var1 * 4 + 48, var16 + 48 + 4 * (104 - var2 - var20.sizeY));
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var17] = var9;
                  var10[var17 + 512] = var9;
                  var10[var17 + 1024] = var9;
                  var10[1536 + var17] = var9;
               } else if(var7 == 1) {
                  var10[var17] = var9;
                  var10[1 + var17] = var9;
                  var10[var17 + 2] = var9;
                  var10[var17 + 3] = var9;
               } else if(var7 == 2) {
                  var10[3 + var17] = var9;
                  var10[512 + var17 + 3] = var9;
                  var10[1024 + var17 + 3] = var9;
                  var10[3 + var17 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var17] = var9;
                  var10[var17 + 1536 + 1] = var9;
                  var10[2 + 1536 + var17] = var9;
                  var10[3 + var17 + 1536] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var17] = var9;
               } else if(var7 == 1) {
                  var10[var17 + 3] = var9;
               } else if(var7 == 2) {
                  var10[1536 + 3 + var17] = var9;
               } else if(var7 == 3) {
                  var10[var17 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var17] = var9;
                  var10[var17 + 512] = var9;
                  var10[1024 + var17] = var9;
                  var10[var17 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var17] = var9;
                  var10[var17 + 1] = var9;
                  var10[var17 + 2] = var9;
                  var10[var17 + 3] = var9;
               } else if(var7 == 1) {
                  var10[3 + var17] = var9;
                  var10[512 + var17 + 3] = var9;
                  var10[1024 + 3 + var17] = var9;
                  var10[1536 + 3 + var17] = var9;
               } else if(var7 == 2) {
                  var10[1536 + var17] = var9;
                  var10[1 + 1536 + var17] = var9;
                  var10[var17 + 1536 + 2] = var9;
                  var10[3 + var17 + 1536] = var9;
               }
            }
         }
      }

      var5 = Varbit.region.method1784(var0, var1, var2);
      if(var5 != 0) {
         var6 = Varbit.region.method1786(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = class196.getObjectDefinition(var9);
         int var13;
         if(var23.mapSceneId != -1) {
            ModIcon var11 = class32.field732[var23.mapSceneId];
            if(null != var11) {
               var19 = (var23.sizeX * 4 - var11.originalWidth) / 2;
               var13 = (var23.sizeY * 4 - var11.height) / 2;
               var11.method4191(48 + 4 * var1 + var19, var13 + 48 + 4 * (104 - var2 - var23.sizeY));
            }
         } else if(var8 == 9) {
            var17 = 15658734;
            if(var5 > 0) {
               var17 = 15597568;
            }

            int[] var12 = class148.field2025.image;
            var13 = 4 * var1 + 24624 + (103 - var2) * 2048;
            if(var7 != 0 && var7 != 2) {
               var12[var13] = var17;
               var12[512 + var13 + 1] = var17;
               var12[2 + var13 + 1024] = var17;
               var12[3 + 1536 + var13] = var17;
            } else {
               var12[1536 + var13] = var17;
               var12[1024 + var13 + 1] = var17;
               var12[2 + var13 + 512] = var17;
               var12[var13 + 3] = var17;
            }
         }
      }

      var5 = Varbit.region.method1785(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var21 = class196.getObjectDefinition(var6);
         if(var21.mapSceneId != -1) {
            ModIcon var18 = class32.field732[var21.mapSceneId];
            if(var18 != null) {
               var9 = (var21.sizeX * 4 - var18.originalWidth) / 2;
               int var22 = (var21.sizeY * 4 - var18.height) / 2;
               var18.method4191(48 + 4 * var1 + var9, var22 + (104 - var2 - var21.sizeY) * 4 + 48);
            }
         }
      }

   }
}
