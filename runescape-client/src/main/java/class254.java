import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
public class class254 extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   static NodeCache field3402;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   static NodeCache field3401;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   static NodeCache field3400;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   static IndexDataBase field3389;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   static IndexDataBase field3405;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   static IndexDataBase field3388;
   @ObfuscatedName("j")
   String field3404;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1575179621
   )
   int field3408;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2068878047
   )
   int field3397;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 2120555045
   )
   int field3386;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -290108855
   )
   int field3394;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1445977045
   )
   int field3398;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1940833561
   )
   int field3399;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1832218525
   )
   int field3390;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1596963871
   )
   public int field3387;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -914706147
   )
   public int field3409;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1519414451
   )
   public int field3396;
   @ObfuscatedName("b")
   public int[] field3407;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1463279977
   )
   public int field3395;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1387391183
   )
   public int field3403;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1998801091
   )
   public int field3391;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -588311367
   )
   public int field3406;

   static {
      field3401 = new NodeCache(64);
      field3400 = new NodeCache(64);
      field3402 = new NodeCache(20);
   }

   class254() {
      this.field3394 = -1;
      this.field3409 = 16777215;
      this.field3396 = 70;
      this.field3397 = -1;
      this.field3398 = -1;
      this.field3399 = -1;
      this.field3386 = -1;
      this.field3395 = 0;
      this.field3391 = 0;
      this.field3403 = -1;
      this.field3404 = "";
      this.field3387 = -1;
      this.field3406 = 0;
      this.field3408 = -1;
      this.field3390 = -1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "196077343"
   )
   void method4358(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3394 = var1.method3266();
      } else if(var2 == 2) {
         this.field3409 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3397 = var1.method3266();
      } else if(var2 == 4) {
         this.field3399 = var1.method3266();
      } else if(var2 == 5) {
         this.field3398 = var1.method3266();
      } else if(var2 == 6) {
         this.field3386 = var1.method3266();
      } else if(var2 == 7) {
         this.field3395 = var1.readShort();
      } else if(var2 == 8) {
         this.field3404 = var1.getJagString();
      } else if(var2 == 9) {
         this.field3396 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3391 = var1.readShort();
      } else if(var2 == 11) {
         this.field3403 = 0;
      } else if(var2 == 12) {
         this.field3387 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3406 = var1.readShort();
      } else if(var2 == 14) {
         this.field3403 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3408 = var1.readUnsignedShort();
         if(this.field3408 == '\uffff') {
            this.field3408 = -1;
         }

         this.field3390 = var1.readUnsignedShort();
         if(this.field3390 == '\uffff') {
            this.field3390 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3407 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3407[var5] = var1.readUnsignedShort();
            if(this.field3407[var5] == '\uffff') {
               this.field3407[var5] = -1;
            }
         }

         this.field3407[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "-1331094939"
   )
   void method4369(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4358(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lid;",
      garbageValue = "636584165"
   )
   public final class254 method4388() {
      int var1 = -1;
      if(this.field3408 != -1) {
         var1 = class17.method125(this.field3408);
      } else if(this.field3390 != -1) {
         var1 = class211.widgetSettings[this.field3390];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3407.length - 1) {
         var2 = this.field3407[var1];
      } else {
         var2 = this.field3407[this.field3407.length - 1];
      }

      return var2 != -1?DState.method3078(var2):null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Ljj;",
      garbageValue = "513073365"
   )
   public SpritePixels method4363() {
      if(this.field3397 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3400.get((long)this.field3397);
         if(var1 != null) {
            return var1;
         } else {
            var1 = NPCComposition.method4549(field3405, this.field3397, 0);
            if(var1 != null) {
               field3400.put(var1, (long)this.field3397);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Ljj;",
      garbageValue = "-1105374111"
   )
   public SpritePixels method4359() {
      if(this.field3398 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3400.get((long)this.field3398);
         if(var1 != null) {
            return var1;
         } else {
            var1 = NPCComposition.method4549(field3405, this.field3398, 0);
            if(var1 != null) {
               field3400.put(var1, (long)this.field3398);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Ljj;",
      garbageValue = "995288497"
   )
   public SpritePixels method4364() {
      if(this.field3399 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3400.get((long)this.field3399);
         if(var1 != null) {
            return var1;
         } else {
            var1 = NPCComposition.method4549(field3405, this.field3399, 0);
            if(var1 != null) {
               field3400.put(var1, (long)this.field3399);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Ljj;",
      garbageValue = "1032924111"
   )
   public SpritePixels method4365() {
      if(this.field3386 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3400.get((long)this.field3386);
         if(var1 != null) {
            return var1;
         } else {
            var1 = NPCComposition.method4549(field3405, this.field3386, 0);
            if(var1 != null) {
               field3400.put(var1, (long)this.field3386);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Ljt;",
      garbageValue = "-125"
   )
   public Font method4366() {
      if(this.field3394 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3402.get((long)this.field3394);
         if(var1 != null) {
            return var1;
         } else {
            var1 = method4396(field3405, field3388, this.field3394, 0);
            if(var1 != null) {
               field3402.put(var1, (long)this.field3394);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1869599352"
   )
   public String method4362(int var1) {
      String var2 = this.field3404;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         String var4 = var2.substring(0, var3);
         String var5 = Integer.toString(var1);
         var2 = var4 + var5 + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lip;Lip;III)Ljt;",
      garbageValue = "142279777"
   )
   public static Font method4396(IndexDataBase var0, IndexDataBase var1, int var2, int var3) {
      if(!ISAACCipher.method3381(var0, var2, var3)) {
         return null;
      } else {
         byte[] var5 = var1.getConfigData(var2, var3);
         Font var4;
         if(var5 == null) {
            var4 = null;
         } else {
            Font var6 = new Font(var5, class286.field3782, class286.offsetsY, class286.field3779, class286.field3787, class286.field3786, class286.spritePixels);
            class286.field3782 = null;
            class286.offsetsY = null;
            class286.field3779 = null;
            class286.field3787 = null;
            class286.field3786 = null;
            class286.spritePixels = null;
            var4 = var6;
         }

         return var4;
      }
   }
}
