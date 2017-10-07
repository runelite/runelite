import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("CombatInfo2")
public class CombatInfo2 extends CacheableNode {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   public static NodeCache field3362;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("spriteCache")
   public static NodeCache spriteCache;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public static IndexDataBase field3366;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public static IndexDataBase field3361;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -618096329
   )
   int field3372;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 302902847
   )
   int field3373;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1590978673
   )
   public int field3360;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1656396935
   )
   public int field3369;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1786144107
   )
   public int field3365;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1422064869
   )
   public int field3371;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1889517969
   )
   public int field3370;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1888932887
   )
   public int field3364;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1133024047
   )
   @Export("healthScale")
   public int healthScale;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1049973827
   )
   public int field3367;

   static {
      field3362 = new NodeCache(64);
      spriteCache = new NodeCache(64);
   }

   CombatInfo2() {
      this.field3360 = 255;
      this.field3369 = 255;
      this.field3365 = -1;
      this.field3370 = 1;
      this.field3371 = 70;
      this.field3372 = -1;
      this.field3373 = -1;
      this.healthScale = 30;
      this.field3367 = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfg;II)V",
      garbageValue = "1924487439"
   )
   void method4488(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3360 = var1.readUnsignedByte();
      } else if(var2 == 3) {
         this.field3369 = var1.readUnsignedByte();
      } else if(var2 == 4) {
         this.field3365 = 0;
      } else if(var2 == 5) {
         this.field3371 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         var1.readUnsignedByte();
      } else if(var2 == 7) {
         this.field3372 = var1.method3252();
      } else if(var2 == 8) {
         this.field3373 = var1.method3252();
      } else if(var2 == 11) {
         this.field3365 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.healthScale = var1.readUnsignedByte();
      } else if(var2 == 15) {
         this.field3367 = var1.readUnsignedByte();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfg;I)V",
      garbageValue = "-72699693"
   )
   void method4487(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4488(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Lkr;",
      garbageValue = "-531174998"
   )
   public SpritePixels method4490() {
      if(this.field3373 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3373);
         if(var1 != null) {
            return var1;
         } else {
            var1 = AbstractSoundSystem.method2136(field3361, this.field3373, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3373);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Lkr;",
      garbageValue = "-478181061"
   )
   public SpritePixels method4504() {
      if(this.field3372 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field3372);
         if(var1 != null) {
            return var1;
         } else {
            var1 = AbstractSoundSystem.method2136(field3361, this.field3372, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field3372);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "1172869494"
   )
   static int method4486(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 == 2700) {
         var3 = PacketBuffer.method3528(class81.intStack[--class81.intStackSize]);
         class81.intStack[++class81.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 2701) {
         var3 = PacketBuffer.method3528(class81.intStack[--class81.intStackSize]);
         if(var3.itemId != -1) {
            class81.intStack[++class81.intStackSize - 1] = var3.itemQuantity;
         } else {
            class81.intStack[++class81.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 2702) {
         int var5 = class81.intStack[--class81.intStackSize];
         WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var5);
         if(var4 != null) {
            class81.intStack[++class81.intStackSize - 1] = 1;
         } else {
            class81.intStack[++class81.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 2706) {
         class81.intStack[++class81.intStackSize - 1] = Client.widgetRoot;
         return 1;
      } else {
         return 2;
      }
   }
}
