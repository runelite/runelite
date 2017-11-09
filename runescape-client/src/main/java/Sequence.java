import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jf")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("skel_ref")
   public static IndexDataBase skel_ref;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("skin_ref")
   public static IndexDataBase skin_ref;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("sequences")
   public static NodeCache sequences;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("skeletons")
   public static NodeCache skeletons;
   @ObfuscatedName("x")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("e")
   int[] field3669;
   @ObfuscatedName("l")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("b")
   public int[] field3662;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1626689883
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("c")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("a")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1627594133
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -41190273
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 18695685
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1302466965
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 300812355
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1411840355
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1693956885
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfv;S)V",
      garbageValue = "-2349"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4891(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfv;IB)V",
      garbageValue = "49"
   )
   void method4891(Buffer var1, int var2) {
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
         this.field3669 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3669[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3669[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3662 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3662[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "75"
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Len;II)Len;",
      garbageValue = "-2030762504"
   )
   public Model method4877(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = ScriptVarType.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2640(true);
      } else {
         Model var4 = var1.method2640(!var3.method2980(var2));
         var4.method2620(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Len;IIB)Len;",
      garbageValue = "3"
   )
   Model method4878(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = ScriptVarType.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var4 == null) {
         return var1.method2640(true);
      } else {
         Model var5 = var1.method2640(!var4.method2980(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2654();
         } else if(var3 == 2) {
            var5.method2637();
         } else if(var3 == 3) {
            var5.method2677();
         }

         var5.method2620(var4, var2);
         if(var3 == 1) {
            var5.method2677();
         } else if(var3 == 2) {
            var5.method2637();
         } else if(var3 == 3) {
            var5.method2654();
         }

         return var5;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Len;II)Len;",
      garbageValue = "387845339"
   )
   Model method4879(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = ScriptVarType.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2613(true);
      } else {
         Model var4 = var1.method2613(!var3.method2980(var2));
         var4.method2620(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Len;ILjf;IB)Len;",
      garbageValue = "38"
   )
   public Model method4880(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = ScriptVarType.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var5 == null) {
         return var3.method4877(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = ScriptVarType.getFrames(var4 >> 16);
         var4 &= 65535;
         Model var7;
         if(var6 == null) {
            var7 = var1.method2640(!var5.method2980(var2));
            var7.method2620(var5, var2);
            return var7;
         } else {
            var7 = var1.method2640(!var5.method2980(var2) & !var6.method2980(var4));
            var7.method2621(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Len;IB)Len;",
      garbageValue = "-1"
   )
   public Model method4881(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = ScriptVarType.getFrames(var3 >> 16);
      var3 &= 65535;
      if(var4 == null) {
         return var1.method2640(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3669 != null && var2 < this.field3669.length) {
            var6 = this.field3669[var2];
            var5 = ScriptVarType.getFrames(var6 >> 16);
            var6 &= 65535;
         }

         Model var7;
         if(var5 != null && var6 != 65535) {
            var7 = var1.method2640(!var4.method2980(var3) & !var5.method2980(var6));
            var7.method2620(var4, var3);
            var7.method2620(var5, var6);
            return var7;
         } else {
            var7 = var1.method2640(!var4.method2980(var3));
            var7.method2620(var4, var3);
            return var7;
         }
      }
   }
}
