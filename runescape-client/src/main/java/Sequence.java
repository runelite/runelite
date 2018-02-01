import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jm")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("seq_ref")
   public static IndexDataBase seq_ref;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("skel_ref")
   public static IndexDataBase skel_ref;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("skin_ref")
   public static IndexDataBase skin_ref;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   @Export("sequences")
   static NodeCache sequences;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   @Export("skeletons")
   static NodeCache skeletons;
   @ObfuscatedName("a")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("t")
   int[] field3660;
   @ObfuscatedName("r")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("m")
   public int[] field3662;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 376482635
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("o")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("x")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -907532735
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -845115623
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 351824339
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -890930013
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1776413621
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -976834497
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 686625211
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgj;B)V",
      garbageValue = "0"
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgj;II)V",
      garbageValue = "-1516481619"
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
         this.field3660 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3660[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3660[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3662 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3662[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-645680286"
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Len;II)Len;",
      garbageValue = "-706644218"
   )
   public Model method4958(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = BuildType.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2657(true);
      } else {
         Model var4 = var1.method2657(!var3.method3008(var2));
         var4.method2664(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Len;III)Len;",
      garbageValue = "-544285789"
   )
   Model method4952(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = BuildType.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var4 == null) {
         return var1.method2657(true);
      } else {
         Model var5 = var1.method2657(!var4.method3008(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2669();
         } else if(var3 == 2) {
            var5.method2689();
         } else if(var3 == 3) {
            var5.rotateY90Ccw();
         }

         var5.method2664(var4, var2);
         if(var3 == 1) {
            var5.rotateY90Ccw();
         } else if(var3 == 2) {
            var5.method2689();
         } else if(var3 == 3) {
            var5.method2669();
         }

         return var5;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Len;IB)Len;",
      garbageValue = "10"
   )
   Model method4953(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = BuildType.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2681(true);
      } else {
         Model var4 = var1.method2681(!var3.method3008(var2));
         var4.method2664(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Len;ILjm;II)Len;",
      garbageValue = "2145196786"
   )
   public Model method4954(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = BuildType.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var5 == null) {
         return var3.method4958(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = BuildType.getFrames(var4 >> 16);
         var4 &= 65535;
         Model var7;
         if(var6 == null) {
            var7 = var1.method2657(!var5.method3008(var2));
            var7.method2664(var5, var2);
            return var7;
         } else {
            var7 = var1.method2657(!var5.method3008(var2) & !var6.method3008(var4));
            var7.method2717(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Len;IB)Len;",
      garbageValue = "34"
   )
   public Model method4951(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = BuildType.getFrames(var3 >> 16);
      var3 &= 65535;
      if(var4 == null) {
         return var1.method2657(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3660 != null && var2 < this.field3660.length) {
            var6 = this.field3660[var2];
            var5 = BuildType.getFrames(var6 >> 16);
            var6 &= 65535;
         }

         Model var7;
         if(var5 != null && var6 != 65535) {
            var7 = var1.method2657(!var4.method3008(var3) & !var5.method3008(var6));
            var7.method2664(var4, var3);
            var7.method2664(var5, var6);
            return var7;
         } else {
            var7 = var1.method2657(!var4.method3008(var3));
            var7.method2664(var4, var3);
            return var7;
         }
      }
   }
}
