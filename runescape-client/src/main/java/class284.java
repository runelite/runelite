import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
public class class284 extends NameableContainer {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lla;"
   )
   final JagexLoginType field3636;

   @ObfuscatedSignature(
      signature = "(Lla;)V"
   )
   public class284(JagexLoginType var1) {
      super(400);
      this.field3636 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Ljn;",
      garbageValue = "-39"
   )
   Nameable vmethod5491() {
      return new Ignore();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)[Ljn;",
      garbageValue = "-1283030275"
   )
   Nameable[] vmethod5492(int var1) {
      return new Ignore[var1];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgy;IB)V",
      garbageValue = "27"
   )
   public void method5333(Buffer var1, int var2) {
      while(true) {
         if(var1.offset < var2) {
            int var3 = var1.readUnsignedByte();
            boolean var4 = (var3 & 1) == 1;
            Name var5 = new Name(var1.readString(), this.field3636);
            Name var6 = new Name(var1.readString(), this.field3636);
            var1.readString();
            if(var5 != null && var5.isCleanNameValid()) {
               Ignore var7 = (Ignore)this.method5374(var5);
               if(var4) {
                  Ignore var8 = (Ignore)this.method5374(var6);
                  if(var8 != null && var7 != var8) {
                     if(var7 != null) {
                        this.method5362(var8);
                     } else {
                        var7 = var8;
                     }
                  }
               }

               if(var7 != null) {
                  this.method5339(var7, var5, var6);
                  continue;
               }

               if(this.getCount() < 400) {
                  int var9 = this.getCount();
                  var7 = (Ignore)this.method5373(var5, var6);
                  var7.field3646 = var9;
               }
               continue;
            }

            throw new IllegalStateException();
         }

         return;
      }
   }
}
