import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
public class class282 extends class275 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lld;"
   )
   final JagexLoginType field3709;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ljh;"
   )
   final class277 field3710;
   @ObfuscatedName("m")
   public String field3713;
   @ObfuscatedName("h")
   public String field3708;
   @ObfuscatedName("o")
   public byte field3711;
   @ObfuscatedName("x")
   public byte field3714;

   @ObfuscatedSignature(
      signature = "(Lld;Ljh;)V"
   )
   public class282(JagexLoginType var1, class277 var2) {
      super(100);
      this.field3713 = null;
      this.field3708 = null;
      this.field3709 = var1;
      this.field3710 = var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lju;",
      garbageValue = "-98"
   )
   class273 vmethod5160() {
      return new class272();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)[Lju;",
      garbageValue = "-1319508722"
   )
   class273[] vmethod5161(int var1) {
      return new class272[var1];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1430253261"
   )
   final void method5162(String var1) {
      this.field3713 = BoundingBox.method65(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "1"
   )
   final void method5163(String var1) {
      this.field3708 = BoundingBox.method65(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgj;S)V",
      garbageValue = "14572"
   )
   public final void method5164(Buffer var1) {
      this.method5163(var1.readString());
      long var2 = var1.readLong();
      this.method5162(class46.method687(var2));
      this.field3711 = var1.readByte();
      int var4 = var1.readUnsignedByte();
      if(var4 != 255) {
         this.method5067();

         for(int var5 = 0; var5 < var4; ++var5) {
            class272 var6 = (class272)this.method5034(new class280(var1.readString(), this.field3709));
            var6.field3673 = var1.readUnsignedShort();
            var6.field3674 = var1.readByte();
            var1.readString();
            this.method5168(var6);
         }

      }
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(Lgj;I)V",
      garbageValue = "-382151944"
   )
   public final void method5165(Buffer var1) {
      class280 var2 = new class280(var1.readString(), this.field3709);
      int var3 = var1.readUnsignedShort();
      byte var4 = var1.readByte();
      boolean var5 = false;
      if(var4 == -128) {
         var5 = true;
      }

      class272 var6;
      if(var5) {
         if(this.method5036() == 0) {
            return;
         }

         var6 = (class272)this.method5040(var2);
         if(var6 != null && var3 == var6.field3673) {
            this.method5043(var6);
         }
      } else {
         var1.readString();
         var6 = (class272)this.method5039(var2);
         if(var6 == null) {
            if(this.method5036() > super.field3685) {
               return;
            }

            var6 = (class272)this.method5034(var2);
         }

         var6.field3673 = var3;
         var6.field3674 = var4;
         this.method5168(var6);
      }

   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1302275940"
   )
   public final void method5166() {
      for(int var1 = 0; var1 < this.method5036(); ++var1) {
         ((class272)this.method5054(var1)).method4993();
      }

   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1915495201"
   )
   public final void method5167() {
      for(int var1 = 0; var1 < this.method5036(); ++var1) {
         ((class272)this.method5054(var1)).method4976();
      }

   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(Ljy;B)V",
      garbageValue = "104"
   )
   final void method5168(class272 var1) {
      if(var1.method5001().equals(this.field3710.vmethod5106())) {
         this.field3714 = var1.field3674;
      }

   }
}
