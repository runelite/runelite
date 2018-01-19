import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
@Implements("PacketNode")
public class PacketNode extends Node {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "[Lfy;"
   )
   @Export("packetBufferNodes")
   public static PacketNode[] packetBufferNodes;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1293916423
   )
   public static int field2453;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lfj;"
   )
   @Export("clientPacket")
   public ClientPacket clientPacket;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2010072033
   )
   public int field2448;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("packetBuffer")
   public PacketBuffer packetBuffer;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1285250037
   )
   public int field2451;

   static {
      packetBufferNodes = new PacketNode[300];
      field2453 = 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-18"
   )
   public void method3252() {
      if(field2453 < packetBufferNodes.length) {
         packetBufferNodes[++field2453 - 1] = this;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)Ljd;",
      garbageValue = "1"
   )
   public static class265 method3257(int var0) {
      class265 var1 = (class265)class265.field3506.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class265.field3515.getConfigData(32, var0);
         var1 = new class265();
         if(var2 != null) {
            var1.method4673(new Buffer(var2));
         }

         class265.field3506.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "1"
   )
   public static int method3255(int var0) {
      var0 = (var0 & 1431655765) + (var0 >>> 1 & 1431655765);
      var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
      var0 = var0 + (var0 >>> 4) & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "-1423243978"
   )
   @Export("parseInt")
   public static int parseInt(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == '-') {
                  var3 = true;
                  continue;
               }

               if(var8 == '+') {
                  continue;
               }
            }

            int var10;
            if(var8 >= '0' && var8 <= '9') {
               var10 = var8 - '0';
            } else if(var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - '7';
            } else {
               if(var8 < 'a' || var8 > 'z') {
                  throw new NumberFormatException();
               }

               var10 = var8 - 'W';
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var5 * var1;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1999425330"
   )
   public static void method3249() {
      if(class249.NetCache_socket != null) {
         class249.NetCache_socket.vmethod3136();
      }

   }
}
