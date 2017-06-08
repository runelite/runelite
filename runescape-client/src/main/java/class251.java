import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
public class class251 extends CacheableNode {
   @ObfuscatedName("m")
   boolean field3387;
   @ObfuscatedName("p")
   public static NodeCache field3388;
   @ObfuscatedName("n")
   static IndexDataBase field3389;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 197864549
   )
   public int field3390;
   @ObfuscatedName("f")
   public String field3391;
   @ObfuscatedName("i")
   char field3395;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1752054611"
   )
   void method4454(Buffer var1, int var2) {
      if(var2 == 1) {
         byte var4 = var1.readByte();
         int var5 = var4 & 255;
         if(var5 == 0) {
            throw new IllegalArgumentException("");
         }

         if(var5 >= 128 && var5 < 160) {
            char var6 = class266.field3673[var5 - 128];
            if(var6 == 0) {
               var6 = 63;
            }

            var5 = var6;
         }

         char var3 = (char)var5;
         this.field3395 = var3;
      } else if(var2 == 2) {
         this.field3390 = var1.readInt();
      } else if(var2 == 4) {
         this.field3387 = false;
      } else if(var2 == 5) {
         this.field3391 = var1.readString();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1278258472"
   )
   void method4455() {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "7"
   )
   public boolean method4458() {
      return this.field3395 == 115;
   }

   static {
      field3388 = new NodeCache(64);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "794582395"
   )
   void method4467(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4454(var1, var2);
      }
   }

   class251() {
      this.field3387 = true;
   }

   @ObfuscatedName("jl")
   @ObfuscatedSignature(
      signature = "(LWidget;I)I",
      garbageValue = "1536939084"
   )
   static int method4472(Widget var0) {
      class198 var1 = (class198)Client.widgetFlags.method3545(((long)var0.id << 32) + (long)var0.index);
      return var1 != null?var1.field2496:var0.field2724;
   }
}
