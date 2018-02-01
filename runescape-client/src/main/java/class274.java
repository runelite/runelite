import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jq")
public class class274 extends NameableContainer {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   final JagexLoginType field3679;

   @ObfuscatedSignature(
      signature = "(Lld;)V"
   )
   public class274(JagexLoginType var1) {
      super(400);
      this.field3679 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lju;",
      garbageValue = "-98"
   )
   Nameable vmethod5160() {
      return new Ignore();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)[Lju;",
      garbageValue = "-1319508722"
   )
   Nameable[] vmethod5161(int var1) {
      return new Ignore[var1];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgj;IS)V",
      garbageValue = "-10412"
   )
   public void method5029(Buffer var1, int var2) {
      while(true) {
         if(var1.offset < var2) {
            int var3 = var1.readUnsignedByte();
            boolean var4 = (var3 & 1) == 1;
            Name var5 = new Name(var1.readString(), this.field3679);
            Name var6 = new Name(var1.readString(), this.field3679);
            var1.readString();
            if(var5 != null && var5.method5132()) {
               Ignore var7 = (Ignore)this.method5040(var4?var6:var5);
               if(var7 != null) {
                  this.method5042(var7, var5, var6);
                  continue;
               }

               if(this.getCount() < 400) {
                  var7 = (Ignore)this.method5045(var5, var6);
               }
               continue;
            }

            throw new IllegalStateException();
         }

         return;
      }
   }
}
