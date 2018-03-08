import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kf")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   @Export("skel_ref")
   public static IndexDataBase skel_ref;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   @Export("skin_ref")
   public static IndexDataBase skin_ref;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("sequences")
   static NodeCache sequences;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("skeletons")
   static NodeCache skeletons;
   @ObfuscatedName("b")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("e")
   int[] field3760;
   @ObfuscatedName("x")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("p")
   public int[] field3762;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 651677221
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("n")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("o")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2098108753
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1163189247
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -715976547
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 840256573
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -448122863
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1107839961
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1309499953
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgb;I)V",
      garbageValue = "716850768"
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgb;II)V",
      garbageValue = "919292167"
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
         this.field3760 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3760[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3760[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3762 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3762[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("a")
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lek;IB)Lek;",
      garbageValue = "36"
   )
   public Model method5168(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = ISAACCipher.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2686(true);
      } else {
         Model var4 = var1.method2686(!var3.method3052(var2));
         var4.method2746(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lek;IIB)Lek;",
      garbageValue = "60"
   )
   Model method5185(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = ISAACCipher.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var4 == null) {
         return var1.method2686(true);
      } else {
         Model var5 = var1.method2686(!var4.method3052(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2718();
         } else if(var3 == 2) {
            var5.method2750();
         } else if(var3 == 3) {
            var5.rotateY90Ccw();
         }

         var5.method2746(var4, var2);
         if(var3 == 1) {
            var5.rotateY90Ccw();
         } else if(var3 == 2) {
            var5.method2750();
         } else if(var3 == 3) {
            var5.method2718();
         }

         return var5;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lek;IB)Lek;",
      garbageValue = "120"
   )
   Model method5180(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = ISAACCipher.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2697(true);
      } else {
         Model var4 = var1.method2697(!var3.method3052(var2));
         var4.method2746(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lek;ILkf;IB)Lek;",
      garbageValue = "1"
   )
   public Model method5171(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = ISAACCipher.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var5 == null) {
         return var3.method5168(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = ISAACCipher.getFrames(var4 >> 16);
         var4 &= 65535;
         Model var7;
         if(var6 == null) {
            var7 = var1.method2686(!var5.method3052(var2));
            var7.method2746(var5, var2);
            return var7;
         } else {
            var7 = var1.method2686(!var5.method3052(var2) & !var6.method3052(var4));
            var7.method2712(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lek;IB)Lek;",
      garbageValue = "26"
   )
   public Model method5172(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = ISAACCipher.getFrames(var3 >> 16);
      var3 &= 65535;
      if(var4 == null) {
         return var1.method2686(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3760 != null && var2 < this.field3760.length) {
            var6 = this.field3760[var2];
            var5 = ISAACCipher.getFrames(var6 >> 16);
            var6 &= 65535;
         }

         Model var7;
         if(var5 != null && var6 != 65535) {
            var7 = var1.method2686(!var4.method3052(var3) & !var5.method3052(var6));
            var7.method2746(var4, var3);
            var7.method2746(var5, var6);
            return var7;
         } else {
            var7 = var1.method2686(!var4.method3052(var3));
            var7.method2746(var4, var3);
            return var7;
         }
      }
   }
}
