import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public abstract class class9 extends Node {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 385031027
   )
   @Export("priority")
   public static int priority;
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      intValue = 171439365
   )
   static int field248;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-36"
   )
   abstract void vmethod53();

   @ObfuscatedName("n")
   static final void method41(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZB)V",
      garbageValue = "0"
   )
   public static void method46(String var0, boolean var1, boolean var2) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var4) {
               ;
            }
         }

         if(class56.field661.startsWith("win")) {
            ScriptVarType.method24(var0, 0);
         } else if(class56.field661.startsWith("mac")) {
            WidgetNode.method1092(var0, 1, "openjs");
         } else {
            ScriptVarType.method24(var0, 2);
         }
      } else {
         ScriptVarType.method24(var0, 3);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lkt;I)Ljava/lang/String;",
      garbageValue = "-787758433"
   )
   public static String method50(CharSequence var0, class290 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         boolean var4;
         char var5;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            var5 = var0.charAt(var2);
            var4 = var5 == 160 || var5 == 32 || var5 == 95 || var5 == 45;
            if(!var4) {
               break;
            }
         }

         while(var3 > var2) {
            var5 = var0.charAt(var3 - 1);
            var4 = var5 == 160 || var5 == 32 || var5 == 95 || var5 == 45;
            if(!var4) {
               break;
            }

            --var3;
         }

         int var10 = var3 - var2;
         if(var10 >= 1) {
            byte var6;
            if(var1 == null) {
               var6 = 12;
            } else {
               switch(var1.field3845) {
               case 6:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var10 <= var6) {
               StringBuilder var9 = new StringBuilder(var10);

               for(int var11 = var2; var11 < var3; ++var11) {
                  char var7 = var0.charAt(var11);
                  if(class64.method1084(var7)) {
                     char var8 = class223.method4076(var7);
                     if(var8 != 0) {
                        var9.append(var8);
                     }
                  }
               }

               if(var9.length() == 0) {
                  return null;
               }

               return var9.toString();
            }
         }

         return null;
      }
   }

   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "(Lcp;B)V",
      garbageValue = "79"
   )
   static final void method43(Actor var0) {
      int var1 = var0.field1238 - Client.gameCycle;
      int var2 = var0.field1247 * 128 + var0.field1254 * 64;
      int var3 = var0.field1254 * 64 + var0.field1251 * 128;
      var0.x += (var2 - var0.x) / var1;
      var0.y += (var3 - var0.y) / var1;
      var0.field1263 = 0;
      var0.orientation = var0.field1253;
   }

   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "1337453017"
   )
   @Export("isFriended")
   static boolean isFriended(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = method50(var0, class29.field422);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(method50(Client.friends[var3].name, class29.field422)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(method50(class54.localPlayer.name, class29.field422))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILhc;I)Lcc;",
      garbageValue = "-1522530424"
   )
   static Script method49(int var0, class220 var1) {
      Script var2 = (Script)Script.field1525.get((long)(var0 << 16));
      if(var2 != null) {
         return var2;
      } else {
         String var3 = String.valueOf(var0);
         int var4 = class253.indexScripts.getFile(var3);
         if(var4 == -1) {
            return null;
         } else {
            byte[] var5 = class253.indexScripts.method4120(var4);
            if(var5 != null) {
               if(var5.length <= 1) {
                  return null;
               }

               var2 = class97.method1829(var5);
               if(var2 != null) {
                  Script.field1525.put(var2, (long)(var0 << 16));
                  return var2;
               }
            }

            return null;
         }
      }
   }
}
