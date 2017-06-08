import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
public class class243 extends CacheableNode {
   @ObfuscatedName("p")
   static NodeCache field3316;
   @ObfuscatedName("i")
   public boolean field3317;
   @ObfuscatedName("n")
   public static IndexDataBase field3318;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-786291828"
   )
   public static void method4332(int var0) {
      class59.mouseIdleTicks = var0;
   }

   class243() {
      this.field3317 = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "47"
   )
   void method4333(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3317 = true;
      }

   }

   static {
      field3316 = new NodeCache(64);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-128367635"
   )
   static int method4340(int var0, Script var1, boolean var2) {
      Widget var3 = class177.method3390(class83.intStack[--class165.intStackSize]);
      if(var0 == 2600) {
         class83.intStack[++class165.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 2601) {
         class83.intStack[++class165.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 2602) {
         class83.scriptStringStack[++ISAACCipher.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 2603) {
         class83.intStack[++class165.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 2604) {
         class83.intStack[++class165.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 2605) {
         class83.intStack[++class165.intStackSize - 1] = var3.field2706;
         return 1;
      } else if(var0 == 2606) {
         class83.intStack[++class165.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 2607) {
         class83.intStack[++class165.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 2608) {
         class83.intStack[++class165.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 2609) {
         class83.intStack[++class165.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 2610) {
         class83.intStack[++class165.intStackSize - 1] = var3.field2684;
         return 1;
      } else if(var0 == 2611) {
         class83.intStack[++class165.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 2612) {
         class83.intStack[++class165.intStackSize - 1] = var3.field2775;
         return 1;
      } else if(var0 == 2613) {
         class83.intStack[++class165.intStackSize - 1] = var3.field2668.vmethod5059();
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass186;III)I",
      garbageValue = "-752506488"
   )
   static int method4341(class186 var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         class198 var3 = (class198)var0.method3493((long)var1);
         return var3 == null?var2:var3.field2496;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-2073722244"
   )
   void method4342(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4333(var1, var2);
      }
   }
}
