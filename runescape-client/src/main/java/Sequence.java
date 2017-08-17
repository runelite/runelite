import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jf")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("skeletons")
   static NodeCache skeletons;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("sequences")
   static NodeCache sequences;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("skin_ref")
   public static IndexDataBase skin_ref;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("seq_ref")
   public static IndexDataBase seq_ref;
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = -1529432315
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 200332377
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("g")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("o")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1631801109
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 696117911
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("l")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("c")
   int[] field3597;
   @ObfuscatedName("m")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 924544347
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1765175391
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -506822611
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1582297741
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1628835701
   )
   @Export("replyMode")
   public int replyMode;
   @ObfuscatedName("w")
   public int[] field3602;

   static {
      sequences = new NodeCache(64);
      skeletons = new NodeCache(100);
   }

   Sequence() {
      this.frameStep = -1;
      this.stretches = false;
      this.forcedPriority = 5;
      this.leftHandItem = -1;
      this.rightHandItem = -1;
      this.maxLoops = 99;
      this.precedenceAnimating = -1;
      this.priority = -1;
      this.replyMode = 2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lfb;II)V",
      garbageValue = "798710319"
   )
   void method4717(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedShort();
         this.frameLenghts = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameLenghts[var4] = var1.readUnsignedShort();
         }

         this.frameIDs = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameIDs[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameIDs[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 2) {
         this.frameStep = var1.readUnsignedShort();
      } else if(var2 == 3) {
         var3 = var1.readUnsignedByte();
         this.interleaveLeave = new int[var3 + 1];

         for(var4 = 0; var4 < var3; ++var4) {
            this.interleaveLeave[var4] = var1.readUnsignedByte();
         }

         this.interleaveLeave[var3] = 9999999;
      } else if(var2 == 4) {
         this.stretches = true;
      } else if(var2 == 5) {
         this.forcedPriority = var1.readUnsignedByte();
      } else if(var2 == 6) {
         this.leftHandItem = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.rightHandItem = var1.readUnsignedShort();
      } else if(var2 == 8) {
         this.maxLoops = var1.readUnsignedByte();
      } else if(var2 == 9) {
         this.precedenceAnimating = var1.readUnsignedByte();
      } else if(var2 == 10) {
         this.priority = var1.readUnsignedByte();
      } else if(var2 == 11) {
         this.replyMode = var1.readUnsignedByte();
      } else if(var2 == 12) {
         var3 = var1.readUnsignedByte();
         this.field3597 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3597[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3597[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3602 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3602[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Leo;II)Leo;",
      garbageValue = "-896494342"
   )
   public Model method4720(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class33.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2525(true);
      } else {
         Model var4 = var1.method2525(!var3.method2898(var2));
         var4.method2531(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Leo;ILjf;II)Leo;",
      garbageValue = "1920651568"
   )
   public Model method4733(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class33.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var5 == null) {
         return var3.method4720(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class33.getFrames(var4 >> 16);
         var4 &= '\uffff';
         Model var7;
         if(var6 == null) {
            var7 = var1.method2525(!var5.method2898(var2));
            var7.method2531(var5, var2);
            return var7;
         } else {
            var7 = var1.method2525(!var5.method2898(var2) & !var6.method2898(var4));
            var7.method2552(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Leo;III)Leo;",
      garbageValue = "-1668171507"
   )
   Model method4729(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class33.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var4 == null) {
         return var1.method2525(true);
      } else {
         Model var5 = var1.method2525(!var4.method2898(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2536();
         } else if(var3 == 2) {
            var5.method2559();
         } else if(var3 == 3) {
            var5.method2535();
         }

         var5.method2531(var4, var2);
         if(var3 == 1) {
            var5.method2535();
         } else if(var3 == 2) {
            var5.method2559();
         } else if(var3 == 3) {
            var5.method2536();
         }

         return var5;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Leo;IB)Leo;",
      garbageValue = "103"
   )
   Model method4718(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class33.getFrames(var2 >> 16);
      var2 &= '\uffff';
      if(var3 == null) {
         return var1.method2526(true);
      } else {
         Model var4 = var1.method2526(!var3.method2898(var2));
         var4.method2531(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Leo;II)Leo;",
      garbageValue = "1175911417"
   )
   public Model method4741(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class33.getFrames(var3 >> 16);
      var3 &= '\uffff';
      if(var4 == null) {
         return var1.method2525(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3597 != null && var2 < this.field3597.length) {
            var6 = this.field3597[var2];
            var5 = class33.getFrames(var6 >> 16);
            var6 &= '\uffff';
         }

         Model var7;
         if(var5 != null && var6 != '\uffff') {
            var7 = var1.method2525(!var4.method2898(var3) & !var5.method2898(var6));
            var7.method2531(var4, var3);
            var7.method2531(var5, var6);
            return var7;
         } else {
            var7 = var1.method2525(!var4.method2898(var3));
            var7.method2531(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   @Export("post")
   void post() {
      if(this.precedenceAnimating == -1) {
         if(this.interleaveLeave != null) {
            this.precedenceAnimating = 2;
         } else {
            this.precedenceAnimating = 0;
         }
      }

      if(this.priority == -1) {
         if(this.interleaveLeave != null) {
            this.priority = 2;
         } else {
            this.priority = 0;
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lfb;I)V",
      garbageValue = "-1900513466"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4717(var1, var2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lia;II)Ljr;",
      garbageValue = "-449660761"
   )
   public static IndexedSprite method4754(IndexDataBase var0, int var1) {
      byte[] var3 = var0.method4119(var1);
      boolean var2;
      if(var3 == null) {
         var2 = false;
      } else {
         class279.decodeSprite(var3);
         var2 = true;
      }

      if(!var2) {
         return null;
      } else {
         IndexedSprite var4 = new IndexedSprite();
         var4.width = class287.field3779;
         var4.originalHeight = ISAACCipher.field2435;
         var4.offsetX = class287.field3781[0];
         var4.offsetY = class211.offsetsY[0];
         var4.originalWidth = class266.field3647[0];
         var4.height = class287.field3782[0];
         var4.palette = class287.field3783;
         var4.pixels = class274.spritePixels[0];
         class287.field3781 = null;
         class211.offsetsY = null;
         class266.field3647 = null;
         class287.field3782 = null;
         class287.field3783 = null;
         class274.spritePixels = null;
         return var4;
      }
   }
}
