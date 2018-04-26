import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("ef")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("kf")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   static Widget field1950;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1562202695
   )
   @Export("id")
   int id;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1380190211
   )
   @Export("count")
   int count;
   @ObfuscatedName("b")
   @Export("types")
   int[] types;
   @ObfuscatedName("z")
   @Export("list")
   int[][] list;

   FrameMap(int var1, byte[] var2) {
      this.id = var1;
      Buffer var3 = new Buffer(var2);
      this.count = var3.readUnsignedByte();
      this.types = new int[this.count];
      this.list = new int[this.count][];

      int var4;
      for(var4 = 0; var4 < this.count; ++var4) {
         this.types[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         this.list[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         for(int var5 = 0; var5 < this.list[var4].length; ++var5) {
            this.list[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("km")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "67"
   )
   static void method2945(String var0) {
      class23.sessionToken = var0;

      try {
         String var1 = InvType.clientInstance.getParameter(Parameters.field3812.key);
         String var2 = InvType.clientInstance.getParameter(Parameters.field3800.key);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         String var5;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            String var4 = var3 + "; Expires=";
            long var6 = class289.method5267() + 94608000000L;
            class204.field2624.setTime(new Date(var6));
            int var8 = class204.field2624.get(7);
            int var9 = class204.field2624.get(5);
            int var10 = class204.field2624.get(2);
            int var11 = class204.field2624.get(1);
            int var12 = class204.field2624.get(11);
            int var13 = class204.field2624.get(12);
            int var14 = class204.field2624.get(13);
            var5 = class204.field2623[var8 - 1] + ", " + var9 / 10 + var9 % 10 + "-" + class204.field2628[0][var10] + "-" + var11 + " " + var12 / 10 + var12 % 10 + ":" + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + " GMT";
            var3 = var4 + var5 + "; Max-Age=" + 94608000L;
         }

         Client var16 = InvType.clientInstance;
         var5 = "document.cookie=\"" + var3 + "\"";
         JSObject.getWindow(var16).eval(var5);
      } catch (Throwable var15) {
         ;
      }

   }
}
