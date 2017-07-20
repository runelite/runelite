import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
public class class251 extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   public static NodeCache field3364;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   static IndexDataBase field3362;
   @ObfuscatedName("i")
   char field3359;
   @ObfuscatedName("m")
   boolean field3361;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 658089969
   )
   public int field3360;
   @ObfuscatedName("g")
   public String field3363;

   static {
      field3364 = new NodeCache(64);
   }

   class251() {
      this.field3361 = true;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "-1397465776"
   )
   void method4317(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3359 = WorldMapType3.method206(var1.readByte());
      } else if(var2 == 2) {
         this.field3360 = var1.readInt();
      } else if(var2 == 4) {
         this.field3361 = false;
      } else if(var2 == 5) {
         this.field3363 = var1.readString();
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1401407587"
   )
   public boolean method4325() {
      return this.field3359 == 115;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "119"
   )
   void method4315() {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "1555597925"
   )
   void method4316(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4317(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "1873036940"
   )
   static char method4331(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      return var0 == 338?'O':(var0 == 339?'o':(var0 == 376?'Y':var0));
   }
}
