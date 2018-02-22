import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kr")
public class class290 extends NameableContainer {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   final JagexLoginType field3730;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2096419551
   )
   int field3728;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   public class215 field3732;

   @ObfuscatedSignature(
      signature = "(Lld;)V"
   )
   public class290(JagexLoginType var1) {
      super(400);
      this.field3728 = 1;
      this.field3732 = new class215();
      this.field3730 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Ljw;",
      garbageValue = "-258832734"
   )
   Nameable vmethod5393() {
      return new Friend();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)[Ljw;",
      garbageValue = "-1"
   )
   Nameable[] vmethod5396(int var1) {
      return new Friend[var1];
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lkp;ZI)Z",
      garbageValue = "-743740671"
   )
   public boolean method5346(Name var1, boolean var2) {
      Friend var3 = (Friend)this.method5307(var1);
      return var3 == null?false:!var2 || var3.world != 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lgn;IB)V",
      garbageValue = "-44"
   )
   public void method5347(Buffer var1, int var2) {
      while(true) {
         if(var1.offset < var2) {
            boolean var3 = var1.readUnsignedByte() == 1;
            Name var4 = new Name(var1.readString(), this.field3730);
            Name var5 = new Name(var1.readString(), this.field3730);
            int var6 = var1.readUnsignedShort();
            int var7 = var1.readUnsignedByte();
            int var8 = var1.readUnsignedByte();
            boolean var9 = (var8 & 2) != 0;
            boolean var10 = (var8 & 1) != 0;
            if(var6 > 0) {
               var1.readString();
               var1.readUnsignedByte();
               var1.readInt();
            }

            var1.readString();
            if(var4 != null && var4.method5359()) {
               Friend var11 = (Friend)this.method5235(var3?var5:var4);
               if(var11 != null) {
                  this.method5243(var11, var4, var5);
                  if(var6 != var11.world) {
                     boolean var12 = true;

                     for(class294 var13 = (class294)this.field3732.method4083(); var13 != null; var13 = (class294)this.field3732.method4084()) {
                        if(var13.field3747.equals(var4)) {
                           if(var6 != 0 && var13.field3749 == 0) {
                              var13.method4092();
                              var12 = false;
                           } else if(var6 == 0 && var13.field3749 != 0) {
                              var13.method4092();
                              var12 = false;
                           }
                        }
                     }

                     if(var12) {
                        this.field3732.method4082(new class294(var4, var6));
                     }
                  }
               } else {
                  if(this.getCount() >= 400) {
                     continue;
                  }

                  var11 = (Friend)this.method5240(var4, var5);
               }

               if(var6 != var11.world) {
                  var11.field3718 = ++this.field3728 - 1;
                  if(var11.world == -1 && var6 == 0) {
                     var11.field3718 = -(var11.field3718 * 129726529) * 1220319169;
                  }

                  var11.world = var6;
               }

               var11.rank = var7;
               var11.field3736 = var9;
               var11.field3737 = var10;
               continue;
            }

            throw new IllegalStateException();
         }

         this.method5242();
         return;
      }
   }
}
