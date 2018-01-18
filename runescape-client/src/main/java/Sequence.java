import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("seq_ref")
   public static IndexDataBase seq_ref;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("skel_ref")
   public static IndexDataBase skel_ref;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("skin_ref")
   public static IndexDataBase skin_ref;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   @Export("sequences")
   public static NodeCache sequences;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   @Export("skeletons")
   public static NodeCache skeletons;
   @ObfuscatedName("d")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("s")
   int[] field3688;
   @ObfuscatedName("b")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("e")
   public int[] field3690;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 332827053
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("z")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("u")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1538169177
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 813918677
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -628531205
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -565156721
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 592248831
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2091801731
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 733525121
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lgv;I)V",
      garbageValue = "1090810513"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lgv;IB)V",
      garbageValue = "33"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
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
         this.field3688 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3688[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3688[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3690 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3690[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-776670310"
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
      signature = "(Les;II)Les;",
      garbageValue = "-1976216317"
   )
   public Model method4916(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class43.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2584(true);
      } else {
         Model var4 = var1.method2584(!var3.method2932(var2));
         var4.method2579(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Les;III)Les;",
      garbageValue = "-237948137"
   )
   Model method4899(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class43.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var4 == null) {
         return var1.method2584(true);
      } else {
         Model var5 = var1.method2584(!var4.method2932(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2623();
         } else if(var3 == 2) {
            var5.method2593();
         } else if(var3 == 3) {
            var5.rotateY90Ccw();
         }

         var5.method2579(var4, var2);
         if(var3 == 1) {
            var5.rotateY90Ccw();
         } else if(var3 == 2) {
            var5.method2593();
         } else if(var3 == 3) {
            var5.method2623();
         }

         return var5;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Les;IB)Les;",
      garbageValue = "7"
   )
   Model method4911(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class43.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2574(true);
      } else {
         Model var4 = var1.method2574(!var3.method2932(var2));
         var4.method2579(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Les;ILjs;II)Les;",
      garbageValue = "226581526"
   )
   public Model method4894(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class43.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var5 == null) {
         return var3.method4916(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class43.getFrames(var4 >> 16);
         var4 &= 65535;
         Model var7;
         if(var6 == null) {
            var7 = var1.method2584(!var5.method2932(var2));
            var7.method2579(var5, var2);
            return var7;
         } else {
            var7 = var1.method2584(!var5.method2932(var2) & !var6.method2932(var4));
            var7.method2640(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Les;II)Les;",
      garbageValue = "1732046826"
   )
   public Model method4906(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class43.getFrames(var3 >> 16);
      var3 &= 65535;
      if(var4 == null) {
         return var1.method2584(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3688 != null && var2 < this.field3688.length) {
            var6 = this.field3688[var2];
            var5 = class43.getFrames(var6 >> 16);
            var6 &= 65535;
         }

         Model var7;
         if(var5 != null && var6 != 65535) {
            var7 = var1.method2584(!var4.method2932(var3) & !var5.method2932(var6));
            var7.method2579(var4, var3);
            var7.method2579(var5, var6);
            return var7;
         } else {
            var7 = var1.method2584(!var4.method2932(var3));
            var7.method2579(var4, var3);
            return var7;
         }
      }
   }
}
