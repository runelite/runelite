import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jq")
public class class284 extends NameableContainer {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   final JagexLoginType field3707;

   @ObfuscatedSignature(
      signature = "(Lld;)V"
   )
   public class284(JagexLoginType var1) {
      super(400);
      this.field3707 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Ljw;",
      garbageValue = "-258832734"
   )
   Nameable vmethod5393() {
      return new Ignore();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)[Ljw;",
      garbageValue = "-1"
   )
   Nameable[] vmethod5396(int var1) {
      return new Ignore[var1];
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgn;II)V",
      garbageValue = "198941939"
   )
   public void method5227(Buffer var1, int var2) {
      while(true) {
         if(var1.offset < var2) {
            int var3 = var1.readUnsignedByte();
            boolean var4 = (var3 & 1) == 1;
            Name var5 = new Name(var1.readString(), this.field3707);
            Name var6 = new Name(var1.readString(), this.field3707);
            var1.readString();
            if(var5 != null && var5.method5359()) {
               Ignore var7 = (Ignore)this.method5235(var4?var6:var5);
               if(var7 != null) {
                  this.method5243(var7, var5, var6);
                  continue;
               }

               if(this.getCount() < 400) {
                  int var8 = this.getCount();
                  var7 = (Ignore)this.method5240(var5, var6);
                  var7.field3716 = var8;
               }
               continue;
            }

            throw new IllegalStateException();
         }

         return;
      }
   }
}
