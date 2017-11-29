import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("ClanMember")
public class ClanMember extends Node {
   @ObfuscatedName("d")
   @Export("username")
   String username;
   @ObfuscatedName("x")
   @Export("name2")
   String name2;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1813023509
   )
   @Export("world")
   int world;
   @ObfuscatedName("z")
   @Export("rank")
   byte rank;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Lic;",
      garbageValue = "-1390134848"
   )
   public static class258 method1187(int var0) {
      class258 var1 = (class258)class258.field3455.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class258.field3454.getConfigData(11, var0);
         var1 = new class258();
         if(var2 != null) {
            var1.method4592(new Buffer(var2));
         }

         var1.method4591();
         class258.field3455.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "908030689"
   )
   static boolean method1188(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class56.field654.startsWith("win")) {
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
            Object var3 = class52.method784(class56.field653, var2, new Object[]{(new URL(class56.field653.getCodeBase(), var0)).toString()});
            return var3 != null;
         } catch (Throwable var6) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class56.field653.getAppletContext().showDocument(new URL(class56.field653.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var7) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            class52.method783(class56.field653, "loggedout");
         } catch (Throwable var9) {
            ;
         }

         try {
            class56.field653.getAppletContext().showDocument(new URL(class56.field653.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var8) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "1"
   )
   public static byte[] method1189() {
      byte[] var0 = new byte[24];

      try {
         class156.randomDat.seek(0L);
         class156.randomDat.read(var0);

         int var1;
         for(var1 = 0; var1 < 24 && var0[var1] == 0; ++var1) {
            ;
         }

         if(var1 >= 24) {
            throw new IOException();
         }
      } catch (Exception var4) {
         for(int var2 = 0; var2 < 24; ++var2) {
            var0[var2] = -1;
         }
      }

      return var0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(S)Lfg;",
      garbageValue = "1597"
   )
   public static Timer method1191() {
      try {
         return new NanoTimer();
      } catch (Throwable var1) {
         return new MilliTimer();
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lid;Ljava/lang/String;Ljava/lang/String;I)Lkl;",
      garbageValue = "-1731636117"
   )
   @Export("getSprite")
   public static IndexedSprite getSprite(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      IndexedSprite var5;
      if(!GroundObject.method2603(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class250.method4476();
      }

      return var5;
   }

   @ObfuscatedName("ke")
   @ObfuscatedSignature(
      signature = "(Lhx;I)I",
      garbageValue = "-548535642"
   )
   @Export("getWidgetConfig")
   static int getWidgetConfig(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetFlags.get(((long)var0.id << 32) + (long)var0.index);
      return var1 != null?var1.value:var0.config;
   }
}
