import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class30 {
   @ObfuscatedName("h")
   boolean field714;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 222384103
   )
   static int field715 = 4;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -426691711
   )
   int field716 = 1;
   @ObfuscatedName("n")
   LinkedHashMap field717 = new LinkedHashMap();
   @ObfuscatedName("al")
   @Export("authCode")
   static String authCode;
   @ObfuscatedName("p")
   boolean field720;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1062699882"
   )
   void method682(boolean var1) {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)LBuffer;",
      garbageValue = "349076247"
   )
   Buffer method684() {
      Buffer var1 = new Buffer(100);
      var1.method2918(field715);
      var1.method2918(this.field714?1:0);
      var1.method2918(this.field720?1:0);
      var1.method2918(this.field716);
      var1.method2918(this.field717.size());
      Iterator var2 = this.field717.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2821(((Integer)var3.getKey()).intValue());
         var1.method2821(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "-1735351571"
   )
   public static void method687(class182 var0) {
      CombatInfoListHolder.field784 = var0;
   }

   class30() {
      this.method682(true);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-233202504"
   )
   public static int method694() {
      return class105.keyboardIdleTicks;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;B)Z",
      garbageValue = "12"
   )
   static boolean method695(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class114.field1791.startsWith("win")) {
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
            Object var3 = class100.method2007(class114.field1789, var2, new Object[]{(new URL(class114.field1789.getCodeBase(), var0)).toString()});
            return null != var3;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class114.field1789.getAppletContext().showDocument(new URL(class114.field1789.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class100.method2003(class114.field1789, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class114.field1789.getAppletContext().showDocument(new URL(class114.field1789.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-127"
   )
   public static boolean method696(int var0) {
      if(Widget.validInterfaces[var0]) {
         return true;
      } else if(!Widget.field2271.method3306(var0)) {
         return false;
      } else {
         int var1 = Widget.field2271.method3313(var0);
         if(var1 == 0) {
            Widget.validInterfaces[var0] = true;
            return true;
         } else {
            if(Widget.widgets[var0] == null) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(null == Widget.widgets[var0][var2]) {
                  byte[] var3 = Widget.field2271.getConfigData(var0, var2);
                  if(var3 != null) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].method3211(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].method3210(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   class30(Buffer var1) {
      if(var1 != null && null != var1.payload) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field715) {
            if(var1.readUnsignedByte() == 1) {
               this.field714 = true;
            }

            if(var2 > 1) {
               this.field720 = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.field716 = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.field717.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method682(true);
         }
      } else {
         this.method682(true);
      }

   }
}
