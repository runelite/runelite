import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class30 {
   @ObfuscatedName("r")
   boolean field683;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -721376175
   )
   int field684 = 1;
   @ObfuscatedName("o")
   boolean field685;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 225539181
   )
   static int field686 = 4;
   @ObfuscatedName("j")
   LinkedHashMap field688 = new LinkedHashMap();

   class30(Buffer var1) {
      if(null != var1 && null != var1.payload) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field686) {
            if(var1.readUnsignedByte() == 1) {
               this.field685 = true;
            }

            if(var2 > 1) {
               this.field683 = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.field684 = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method3062();
                  int var6 = var1.method3062();
                  this.field688.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method688(true);
         }
      } else {
         this.method688(true);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)LBuffer;",
      garbageValue = "-5791338"
   )
   Buffer method684() {
      Buffer var1 = new Buffer(100);
      var1.method2912(field686);
      var1.method2912(this.field685?1:0);
      var1.method2912(this.field683?1:0);
      var1.method2912(this.field684);
      var1.method2912(this.field688.size());
      Iterator var2 = this.field688.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method3057(((Integer)var3.getKey()).intValue());
         var1.method3057(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-2027079096"
   )
   void method688(boolean var1) {
   }

   class30() {
      this.method688(true);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-100"
   )
   public static void method693() {
      CombatInfo2.field2821.reset();
      CombatInfo2.field2814.reset();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1436649661"
   )
   public static boolean method695(int var0) {
      return (var0 >> 29 & 1) != 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZB)I",
      garbageValue = "25"
   )
   static int method697(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method655()?(var1.method655()?0:1):(var1.method655()?-1:0)):(var2 == 5?(var0.method678()?(var1.method678()?0:1):(var1.method678()?-1:0)):(var2 == 6?(var0.method654()?(var1.method654()?0:1):(var1.method654()?-1:0)):(var2 == 7?(var0.method652()?(var1.method652()?0:1):(var1.method652()?-1:0)):var0.id - var1.id)))));
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-47"
   )
   public static void method698() {
      ItemComposition.field2932.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
   }
}
