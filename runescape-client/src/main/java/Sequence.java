import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("seq_ref")
   static IndexDataBase seq_ref;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("skel_ref")
   static IndexDataBase skel_ref;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("sequences")
   public static NodeCache sequences;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("skeletons")
   public static NodeCache skeletons;
   @ObfuscatedName("m")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("b")
   int[] field3676;
   @ObfuscatedName("t")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("p")
   public int[] field3671;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1721259623
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("l")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("u")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2096887125
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 916466743
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1661429741
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -171094589
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2089156579
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -306912251
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1473509375
   )
   @Export("replyMode")
   public int replyMode;

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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfr;B)V",
      garbageValue = "44"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4903(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lfr;II)V",
      garbageValue = "-1089620980"
   )
   void method4903(Buffer var1, int var2) {
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
         this.field3676 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3676[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3676[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3671 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3671[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Leh;II)Leh;",
      garbageValue = "-1948339809"
   )
   public Model method4882(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class256.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2619(true);
      } else {
         Model var4 = var1.method2619(!var3.method2997(var2));
         var4.method2627(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Leh;III)Leh;",
      garbageValue = "-1333038516"
   )
   Model method4883(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class256.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var4 == null) {
         return var1.method2619(true);
      } else {
         Model var5 = var1.method2619(!var4.method2997(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2647();
         } else if(var3 == 2) {
            var5.method2679();
         } else if(var3 == 3) {
            var5.method2630();
         }

         var5.method2627(var4, var2);
         if(var3 == 1) {
            var5.method2630();
         } else if(var3 == 2) {
            var5.method2679();
         } else if(var3 == 3) {
            var5.method2647();
         }

         return var5;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Leh;II)Leh;",
      garbageValue = "2125392727"
   )
   Model method4884(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class256.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2620(true);
      } else {
         Model var4 = var1.method2620(!var3.method2997(var2));
         var4.method2627(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Leh;ILjj;II)Leh;",
      garbageValue = "2081500944"
   )
   public Model method4880(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class256.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var5 == null) {
         return var3.method4882(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class256.getFrames(var4 >> 16);
         var4 &= 65535;
         Model var7;
         if(var6 == null) {
            var7 = var1.method2619(!var5.method2997(var2));
            var7.method2627(var5, var2);
            return var7;
         } else {
            var7 = var1.method2619(!var5.method2997(var2) & !var6.method2997(var4));
            var7.method2628(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Leh;II)Leh;",
      garbageValue = "-1333960930"
   )
   public Model method4886(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class256.getFrames(var3 >> 16);
      var3 &= 65535;
      if(var4 == null) {
         return var1.method2619(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3676 != null && var2 < this.field3676.length) {
            var6 = this.field3676[var2];
            var5 = class256.getFrames(var6 >> 16);
            var6 &= 65535;
         }

         Model var7;
         if(var5 != null && var6 != 65535) {
            var7 = var1.method2619(!var4.method2997(var3) & !var5.method2997(var6));
            var7.method2627(var4, var3);
            var7.method2627(var5, var6);
            return var7;
         } else {
            var7 = var1.method2619(!var4.method2997(var3));
            var7.method2627(var4, var3);
            return var7;
         }
      }
   }
}
