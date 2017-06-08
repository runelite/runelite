import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iu")
@Implements("Varbit")
public class Varbit extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 875274937
   )
   @Export("leastSignificantBit")
   public int leastSignificantBit;
   @ObfuscatedName("n")
   static IndexDataBase field3381;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 259646071
   )
   @Export("configId")
   public int configId;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2092471495
   )
   @Export("mostSignificantBit")
   public int mostSignificantBit;
   @ObfuscatedName("p")
   public static NodeCache field3385;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-2138451577"
   )
   void method4438(Buffer var1, int var2) {
      if(var2 == 1) {
         this.configId = var1.readUnsignedShort();
         this.leastSignificantBit = var1.readUnsignedByte();
         this.mostSignificantBit = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1071954686"
   )
   void method4441(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4438(var1, var2);
      }
   }

   static {
      field3385 = new NodeCache(64);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;IB)Z",
      garbageValue = "-61"
   )
   public static boolean method4449(IndexDataBase var0, int var1) {
      byte[] var2 = var0.method4131(var1);
      if(var2 == null) {
         return false;
      } else {
         Renderable.method2869(var2);
         return true;
      }
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "425310494"
   )
   static void method4453() {
      if(Client.field1071) {
         Widget var0 = class29.method254(NPC.field1375, Client.field1072);
         if(var0 != null && var0.field2744 != null) {
            class69 var1 = new class69();
            var1.field824 = var0;
            var1.field833 = var0.field2744;
            class227.method4101(var1);
         }

         Client.field1071 = false;
         CombatInfo1.method1515(var0);
      }
   }
}
