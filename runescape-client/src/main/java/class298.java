import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kq")
public class class298 extends NameableContainer {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Llo;"
   )
   final JagexLoginType field3829;

   @ObfuscatedSignature(
      signature = "(Llo;)V"
   )
   public class298(JagexLoginType var1) {
      super(400);
      this.field3829 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lku;",
      garbageValue = "437342171"
   )
   Nameable vmethod5462() {
      return new Ignore();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)[Lku;",
      garbageValue = "-1281183690"
   )
   Nameable[] vmethod5463(int var1) {
      return new Ignore[var1];
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgp;IB)V",
      garbageValue = "40"
   )
   public void method5310(Buffer var1, int var2) {
      while(true) {
         if(var1.offset < var2) {
            int var3 = var1.readUnsignedByte();
            boolean var4 = (var3 & 1) == 1;
            Name var5 = new Name(var1.readString(), this.field3829);
            Name var6 = new Name(var1.readString(), this.field3829);
            var1.readString();
            if(var5 != null && var5.method5450()) {
               Ignore var7 = (Ignore)this.method5319(var5);
               if(var4) {
                  Ignore var8 = (Ignore)this.method5319(var6);
                  if(var8 != null) {
                     if(var7 != null) {
                        this.method5321(var8);
                     } else {
                        var7 = var8;
                     }
                  }
               }

               if(var7 != null) {
                  this.method5326(var7, var5, var6);
                  continue;
               }

               if(this.getCount() < 400) {
                  int var9 = this.getCount();
                  var7 = (Ignore)this.method5323(var5, var6);
                  var7.field3837 = var9;
               }
               continue;
            }

            throw new IllegalStateException();
         }

         return;
      }
   }
}
