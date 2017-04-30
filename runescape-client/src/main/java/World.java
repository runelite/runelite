import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
@Implements("World")
public class World {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1393644151
   )
   static int field669;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 5525853
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("t")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("k")
   @Export("activity")
   String activity;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1838249521
   )
   static int field674;
   @ObfuscatedName("z")
   static int[] field675;
   @ObfuscatedName("l")
   static int[] field676;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 288236961
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("s")
   @Export("address")
   String address;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1769256957
   )
   @Export("id")
   int id;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -500944135
   )
   @Export("location")
   int location;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -260970347
   )
   @Export("index")
   int index;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-940717220"
   )
   boolean method603() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1673666222"
   )
   boolean method604() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "584258502"
   )
   boolean method605() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1863370907"
   )
   boolean method606() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1948957509"
   )
   boolean method608() {
      return (33554432 & this.mask) != 0;
   }

   static {
      field669 = 0;
      field674 = 0;
      field675 = new int[]{1, 1, 1, 1};
      field676 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "97"
   )
   boolean method618() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("es")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "14"
   )
   static final void method640(String var0) {
      if(!var0.equals("")) {
         Client.secretPacketBuffer1.putOpcode(117);
         Client.secretPacketBuffer1.putByte(class36.method753(var0));
         Client.secretPacketBuffer1.method2504(var0);
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(LSequence;IIII)V",
      garbageValue = "1997457071"
   )
   static void method641(Sequence var0, int var1, int var2, int var3) {
      if(Client.field528 < 50 && Client.field527 != 0) {
         if(var0.field3095 != null && var1 < var0.field3095.length) {
            int var4 = var0.field3095[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field529[Client.field528] = var5;
               Client.field530[Client.field528] = var6;
               Client.field442[Client.field528] = 0;
               Client.field504[Client.field528] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field493[Client.field528] = (var9 << 8) + (var8 << 16) + var7;
               ++Client.field528;
            }
         }
      }
   }
}
