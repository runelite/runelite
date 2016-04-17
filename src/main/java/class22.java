import java.io.DataInputStream;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public class class22 extends class204 {
   @ObfuscatedName("w")
   int[] field598;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1821647319
   )
   int field599;
   @ObfuscatedName("c")
   String[] field600;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1400751379
   )
   int field601;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -2081855699
   )
   int field603;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1493309465
   )
   int field604;
   @ObfuscatedName("d")
   int[] field606;
   @ObfuscatedName("a")
   static class193 field607 = new class193(128);

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;I)V",
      garbageValue = "1880645837"
   )
   public static void method655(String var0, Throwable var1) {
      try {
         String var2 = "";
         if(var1 != null) {
            var2 = class38.method851(var1);
         }

         if(var0 != null) {
            if(var1 != null) {
               var2 = var2 + " | ";
            }

            var2 = var2 + var0;
         }

         System.out.println("Error: " + var2);
         var2 = var2.replace(':', '.');
         var2 = var2.replace('@', '_');
         var2 = var2.replace('&', '_');
         var2 = var2.replace('#', '_');
         if(null == class126.field2041) {
            return;
         }

         URL var3 = new URL(class126.field2041.getCodeBase(), "clienterror.ws?c=" + class148.field2217 + "&u=" + class148.field2216 + "&v1=" + class136.field2096 + "&v2=" + class136.field2092 + "&e=" + var2);
         DataInputStream var4 = new DataInputStream(var3.openStream());
         var4.read();
         var4.close();
      } catch (Exception var5) {
         ;
      }

   }

   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "44"
   )
   static final void method656(String var0) {
      if(!var0.equals("")) {
         client.field338.method2873(83);
         client.field338.method2603(class104.method2383(var0));
         client.field338.method2694(var0);
      }
   }
}
