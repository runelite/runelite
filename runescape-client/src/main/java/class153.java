import java.io.IOException;
import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public class class153 {
   @ObfuscatedName("k")
   Inflater field2194;

   public class153() {
      this(-1, 1000000, 1000000);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;[BB)V",
      garbageValue = "0"
   )
   public void method2860(Buffer var1, byte[] var2) {
      if(var1.payload[var1.offset] == 31 && var1.payload[var1.offset + 1] == -117) {
         if(this.field2194 == null) {
            this.field2194 = new Inflater(true);
         }

         try {
            this.field2194.setInput(var1.payload, 10 + var1.offset, var1.payload.length - (var1.offset + 10 + 8));
            this.field2194.inflate(var2);
         } catch (Exception var4) {
            this.field2194.reset();
            throw new RuntimeException("");
         }

         this.field2194.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1000000"
   )
   class153(int var1, int var2, int var3) {
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-200120623"
   )
   static final void method2861(boolean var0) {
      class3.method33();
      ++Client.field327;
      if(Client.field327 >= 50 || var0) {
         Client.field327 = 0;
         if(!Client.field332 && class177.field2657 != null) {
            Client.field321.method3195(212);

            try {
               class177.field2657.method2054(Client.field321.payload, 0, Client.field321.offset);
               Client.field321.offset = 0;
            } catch (IOException var2) {
               Client.field332 = true;
            }
         }

      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "32"
   )
   static final void method2862(boolean var0) {
      for(int var1 = 0; var1 < Client.field317; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.field554[var1]];
         int var3 = (Client.field554[var1] << 14) + 536870912;
         if(var2 != null && var2.vmethod736() && var0 == var2.composition.isVisible && var2.composition.method3702()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field597 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field451 == Client.field404[var4][var5]) {
                     continue;
                  }

                  Client.field404[var4][var5] = Client.field451;
               }

               if(!var2.composition.field3014) {
                  var3 -= Integer.MIN_VALUE;
               }

               class65.region.method1718(class48.plane, var2.x, var2.y, Renderable.method1883(var2.field597 * 64 - 64 + var2.x, var2.y + (var2.field597 * 64 - 64), class48.plane), var2.field597 * 64 - 64 + 60, var2, var2.angle, var3, var2.field593);
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-452200642"
   )
   static final boolean method2863(char var0) {
      if(Character.isISOControl(var0)) {
         return false;
      } else if(class20.method213(var0)) {
         return true;
      } else {
         char[] var1 = class204.field3065;

         int var2;
         char var3;
         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if(var0 == var3) {
               return true;
            }
         }

         var1 = class204.field3066;

         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if(var0 == var3) {
               return true;
            }
         }

         return false;
      }
   }
}
