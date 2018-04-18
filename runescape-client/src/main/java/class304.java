import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kq")
public class class304 extends NameableContainer {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   final JagexLoginType field3857;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1321536967
   )
   int field3855;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   public class220 field3856;

   @ObfuscatedSignature(
      signature = "(Llh;)V"
   )
   public class304(JagexLoginType var1) {
      super(400);
      this.field3855 = 1;
      this.field3856 = new class220();
      this.field3857 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Lku;",
      garbageValue = "52"
   )
   Nameable vmethod5454() {
      return new Friend();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)[Lku;",
      garbageValue = "1474922336"
   )
   Nameable[] vmethod5462(int var1) {
      return new Friend[var1];
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lkz;ZI)Z",
      garbageValue = "97936795"
   )
   public boolean method5414(Name var1, boolean var2) {
      Friend var3 = (Friend)this.method5307(var1);
      return var3 == null?false:!var2 || var3.world != 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgc;II)V",
      garbageValue = "814744565"
   )
   public void method5411(Buffer var1, int var2) {
      while(true) {
         if(var1.offset < var2) {
            boolean var3 = var1.readUnsignedByte() == 1;
            Name var4 = new Name(var1.readString(), this.field3857);
            Name var5 = new Name(var1.readString(), this.field3857);
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
            if(var4 != null && var4.isCleanNameValid()) {
               Friend var11 = (Friend)this.method5327(var4);
               if(var3) {
                  Friend var12 = (Friend)this.method5327(var5);
                  if(var12 != null && var12 != var11) {
                     if(var11 != null) {
                        this.method5311(var12);
                     } else {
                        var11 = var12;
                     }
                  }
               }

               if(var11 != null) {
                  this.method5316(var11, var4, var5);
                  if(var6 != var11.world) {
                     boolean var14 = true;

                     for(class308 var13 = (class308)this.field3856.method4061(); var13 != null; var13 = (class308)this.field3856.method4060()) {
                        if(var13.field3877.equals(var4)) {
                           if(var6 != 0 && var13.field3875 == 0) {
                              var13.method4067();
                              var14 = false;
                           } else if(var6 == 0 && var13.field3875 != 0) {
                              var13.method4067();
                              var14 = false;
                           }
                        }
                     }

                     if(var14) {
                        this.field3856.method4057(new class308(var4, var6));
                     }
                  }
               } else {
                  if(this.getCount() >= 400) {
                     continue;
                  }

                  var11 = (Friend)this.method5313(var4, var5);
               }

               if(var6 != var11.world) {
                  var11.field3845 = ++this.field3855 - 1;
                  if(var11.world == -1 && var6 == 0) {
                     var11.field3845 = -(var11.field3845 * -1152622641) * 488130351;
                  }

                  var11.world = var6;
               }

               var11.rank = var7;
               var11.field3862 = var9;
               var11.field3861 = var10;
               continue;
            }

            throw new IllegalStateException();
         }

         this.method5331();
         return;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IB)I",
      garbageValue = "58"
   )
   public static int method5422(CharSequence var0, int var1) {
      return class150.parseInt(var0, var1, true);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1951245359"
   )
   public static boolean method5423(int var0) {
      return (var0 >> 31 & 1) != 0;
   }
}
