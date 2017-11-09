import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
public class class258 extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field3446;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   public static NodeCache field3440;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 910364995
   )
   static int field3444;
   @ObfuscatedName("i")
   char field3441;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 139422327
   )
   public int field3443;
   @ObfuscatedName("v")
   public String field3442;
   @ObfuscatedName("x")
   boolean field3445;

   static {
      field3440 = new NodeCache(64);
   }

   class258() {
      this.field3445 = true;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1397427358"
   )
   void method4615() {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfv;I)V",
      garbageValue = "-759710354"
   )
   void method4612(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4614(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfv;IB)V",
      garbageValue = "17"
   )
   void method4614(Buffer var1, int var2) {
      if(var2 == 1) {
         byte var4 = var1.readByte();
         int var5 = var4 & 255;
         if(var5 == 0) {
            throw new IllegalArgumentException("");
         }

         if(var5 >= 128 && var5 < 160) {
            char var6 = class273.field3719[var5 - 128];
            if(var6 == 0) {
               var6 = '?';
            }

            var5 = var6;
         }

         char var3 = (char)var5;
         this.field3441 = var3;
      } else if(var2 == 2) {
         this.field3443 = var1.readInt();
      } else if(var2 == 4) {
         this.field3445 = false;
      } else if(var2 == 5) {
         this.field3442 = var1.readString();
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "-14813"
   )
   public boolean method4611() {
      return this.field3441 == 's';
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "-59"
   )
   @Export("djb2Hash")
   public static int djb2Hash(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class272.method5013(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "(Lhk;B)Z",
      garbageValue = "112"
   )
   static boolean method4629(Widget var0) {
      if(Client.field1081) {
         if(Preferences.getWidgetConfig(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }
}
