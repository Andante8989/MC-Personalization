package sitemap;

public class HP_sitemap {

	SalesforceInteractions.init({
	    // trackUrl: "https://cescocoltd.australia-3.evergage.com",
	}).then(() => {

	    SalesforceInteractions.setLoggingLevel('DEBUG');
	        
	    const sitemapConfig = {
	        global: {
	            locale: "ko",
	            contentZones: [
	                { name: "global_pop_up" },
	                { name: "global_top_banner_pc", selector: "div#mcp_top_banner_pc" },
	                { name: "global_top_banner_mo", selector: "div#mcp_top_banner_mo" },
	            ],
	            listeners: [
	                // ▼ CESCO 홈페이지 - 무료진단 신청 플로팅 버튼 클릭 추적
	                /*
	                SalesforceInteractions.listener("click", "a.float_item[target]", () => {
	                    SalesforceInteractions.sendEvent({
	                        interaction: {
	                            name: "PRD_HP - Click Estimate Button in Information Page",
	                        }
	                    })
	                }),
	                */

	                // ▼ PRD_PC - 로그아웃 버튼 클릭한 경우 캐시 클리어 동작
	                SalesforceInteractions.listener("click", "a[title='로그아웃']", (e) => {
	                    document.dispatchEvent(new CustomEvent(SalesforceInteractions.CustomEvents.OnClearCookie), {
	                        detail: {
	                            options: {
	                                domain: "www.cescomall.co.kr",
	                            },
	                        }
	                    });
	                }),

	                // ▼ PRD_MO - 로그아웃 버튼 클릭한 경우 
	                SalesforceInteractions.listener("click", "a[href='/op_security_logout?target=/m']", (e) => {
	                    document.dispatchEvent(new CustomEvent(SalesforceInteractions.CustomEvents.OnClearCookie), {
	                        detail: {
	                            options: {
	                                domain: "www.cescomall.co.kr",
	                            },
	                        }
	                    });
	                }),
	            ],
	            
	            onActionEvent: (actionEvent) => {

	                // ▼ 파라미터 테스트
	                var currentUrl = window.location.href;

	                if(/\?/.test(currentUrl)) {
	                    
	                    // console.log("======== URL regex 동작")
	                    const  urlParams = new URLSearchParams(currentUrl.substring(currentUrl.indexOf('?') + 1));
	                    var utm_campaign= urlParams.get("utm_campaign");
	                    var utm_content= urlParams.get("utm_content");

	                    // P_001 - utm_campaign & utm_content 추적
	                    // 2024_0613_업데이트  
	                    if(/mylab/.test(utm_campaign) && /summerdetergent_240603/.test(utm_content)) {  // 01_mylab · summerdetergent_240603

	                        actionEvent.user = actionEvent.user || {};
	                        actionEvent.user.attributes = actionEvent.user.attributes || {};
	                        actionEvent.user.attributes.paramValue1 = "mylab";
	                        actionEvent.user.attributes.paramValue2 = "summerdetergent_240603";
	                    } 
	                    else if(/mylab/.test(utm_campaign) && /summerfiber_240603/.test(utm_content)) {  // 02_mylab · summerfiber_240603

	                        actionEvent.user = actionEvent.user || {};
	                        actionEvent.user.attributes = actionEvent.user.attributes || {};
	                        actionEvent.user.attributes.paramValue1 = "mylab";
	                        actionEvent.user.attributes.paramValue2 = "summerfiber_240603";
	                    } 
	                    else if(/mylab/.test(utm_campaign) && /summersanitary_240603/.test(utm_content)) {  // 03_mylab · summersanitary_240603

	                        actionEvent.user = actionEvent.user || {};
	                        actionEvent.user.attributes = actionEvent.user.attributes || {};
	                        actionEvent.user.attributes.paramValue1 = "mylab";
	                        actionEvent.user.attributes.paramValue2 = "summersanitary_240603";
	                    } 
	                    else if(/mylab/.test(utm_campaign) && /summermosquito_240603/.test(utm_content)) {  // 04_mylab · summermosquito_240603

	                        actionEvent.user = actionEvent.user || {};
	                        actionEvent.user.attributes = actionEvent.user.attributes || {};
	                        actionEvent.user.attributes.paramValue1 = "mylab";
	                        actionEvent.user.attributes.paramValue2 = "summermosquito_240603";
	                    } 
	                    else if(/air/.test(utm_campaign) && /basic_240603/.test(utm_content)) {  // 05_air · basic_240603

	                        actionEvent.user = actionEvent.user || {};
	                        actionEvent.user.attributes = actionEvent.user.attributes || {};
	                        actionEvent.user.attributes.paramValue1 = "air";
	                        actionEvent.user.attributes.paramValue2 = "basic_240603";
	                    } 
	                    else if(/bodycare/.test(utm_campaign) && /basic_240603/.test(utm_content)) {  // 06_bodycare · basic_240603

	                        actionEvent.user = actionEvent.user || {};
	                        actionEvent.user.attributes = actionEvent.user.attributes || {};
	                        actionEvent.user.attributes.paramValue1 = "bodycare";
	                        actionEvent.user.attributes.paramValue2 = "basic_240603";
	                    } 
	                    else if(/vcs/.test(utm_campaign) && /basicvirus_240603/.test(utm_content)) {  // 07_vcs · basicvirus_240603

	                        actionEvent.user = actionEvent.user || {};
	                        actionEvent.user.attributes = actionEvent.user.attributes || {};
	                        actionEvent.user.attributes.paramValue1 = "vcs";
	                        actionEvent.user.attributes.paramValue2 = "basicvirus_240603";
	                    } 
	                    else if(/water/.test(utm_campaign) && /basic_240603/.test(utm_content)) {  // 08_water · basic_240603

	                        actionEvent.user = actionEvent.user || {};
	                        actionEvent.user.attributes = actionEvent.user.attributes || {};
	                        actionEvent.user.attributes.paramValue1 = "water";
	                        actionEvent.user.attributes.paramValue2 = "basic_240603";
	                    } 
	                    else if(/ipm/.test(utm_campaign) && /basicfamily_240603/.test(utm_content)) {  // 09_ipm · basicfamily_240603

	                        actionEvent.user = actionEvent.user || {};
	                        actionEvent.user.attributes = actionEvent.user.attributes || {};
	                        actionEvent.user.attributes.paramValue1 = "ipm";
	                        actionEvent.user.attributes.paramValue2 = "basicfamily_240603";
	                    } 
	                    else if(/ipm/.test(utm_campaign) && /basic_240603/.test(utm_content)) {  // 10_ipm · basic_240603

	                        actionEvent.user = actionEvent.user || {};
	                        actionEvent.user.attributes = actionEvent.user.attributes || {};
	                        actionEvent.user.attributes.paramValue1 = "ipm";
	                        actionEvent.user.attributes.paramValue2 = "basic_240603";
	                    } 
	                }
	                    
	                // ▼ 모바일 앱 & 어플리케이션 구분 
	                var userAgent = navigator.userAgent.toLowerCase();
	                var detectApp = userAgent.indexOf("hybridapp-cescomall-android");
	                var mobileAppYn = '';

	                if(detectApp == -1) {

	                    detectApp = userAgent.indexOf("hybridapp-cescomall-ios");

	                    if(detectApp >= 0) {

	                        mobileAppYn = 'Y-iOS';
	                        
	                        actionEvent.user = actionEvent.user || {};
	                        actionEvent.user.attributes = actionEvent.user.attributes || {};
	                        actionEvent.user.attributes.mobileAppYN = mobileAppYn;
	                        // console.log("Detected as a Mobile Application - iOS User");
	                        return actionEvent;
	                    } else {

	                        mobileAppYn = 'N';

	                        actionEvent.user = actionEvent.user || {};
	                        actionEvent.user.attributes = actionEvent.user.attributes || {};
	                        actionEvent.user.attributes.mobileAppYN = mobileAppYn;
	                        
	                        console.log("Detected as a Web User");
	                        return actionEvent;
	                    }
	                    

	                } else if(detectApp >= 0) {

	                    mobileAppYn = 'Y-Android';

	                    actionEvent.user = actionEvent.user || {};
	                    actionEvent.user.attributes = actionEvent.user.attributes || {};
	                    actionEvent.user.attributes.mobileAppYN = mobileAppYn;
	                    // console.log("Detected as a Mobile Application - Android User");
	                    return actionEvent;
	                }
	                return actionEvent;
	            } 
	        },
	        pageTypeDefault: {
	            // DefaultPageConfig
	            name: "default",
	            interaction: {
	                name: "default page"
	            }
	        },
	        pageTypes: [

	//-------------------------------------------------------------------------------------------------------------------//
	//--------------------------------------------------- CESCO MALL  ---------------------------------------------------//
	//-------------------------------------------------------------------------------------------------------------------//

	//------------------------------------------ 메인 페이지 pageType ------------------------------------------//

	            // ▼ PRD_MALL_PC_main : 홈 메인
	            {
	                name: "PRD_MALL_PC_main",
	                isMatch: () => /cescomall\.co\.kr\/newmain/.test(window.location.href),
	                interaction: { 
	                    name: "PRD_MALL_PC - View Main Home Page"
	                },
	                contentZones: [
	                    { name: "PRD_MALL_PC_div_mcp_rec_pc", selector: "div#mcp_rec_pc" },
	                ],
	                listeners: [

	                    // // ▼ Add to Cart - case 1 - + 버튼 클릭한 경우  
	                    SalesforceInteractions.listener("click", "div.img a.btn_cart", (e) => {
	                        
	                        SalesforceInteractions.sendEvent({
	                            interaction: {
	                                name: SalesforceInteractions.CartInteractionName.AddToCart,
	                                lineItem: {
	                                        catalogObjectType: "Product",
	                                        catalogObjectId: e.target.previousElementSibling.getAttribute("href").replace("/products/view/","").trim(),
	                                        price: Number(e.target.parentNode.parentNode.querySelector(".product_price span strong").innerText.replace(/\D/g, "")),
	                                        quantity: 1
	                                },
	                            }
	                        })
	                    }), 
	                    
	                    // ▼ Add to Cart - case 2 - 카트담기 버튼 클릭한 경우
	                    SalesforceInteractions.listener("click", "div.img a.btn_cart span", (e) => {
	                        
	                        e.stopPropagation();

	                        SalesforceInteractions.sendEvent({
	                            interaction: {
	                                name: SalesforceInteractions.CartInteractionName.AddToCart,
	                                lineItem: {
	                                        catalogObjectType: "Product",
	                                        catalogObjectId: e.target.parentNode.parentNode.childNodes[1].getAttribute("href").replace("/products/view/","").trim(),
	                                        price: Number(e.target.parentNode.parentNode.parentNode.childNodes[5].childNodes[3].childNodes[3].innerText.replace(/\D/g, "")),
	                                        quantity: 1
	                                },
	                            }
	                        })
	                    }), 

	                ],
	            },

	            // ▼ PRD_MALL_MO_main : 홈 메인
	            {
	                name: "PRD_MALL_MO_main",
	                isMatch: () => {
	                    return (window.location.href.length = 37 && /m\/newmain/.test(window.location.href));
	                },
	                interaction: {
	                    name: "PRD_MALL_MO - View Main Home Page"
	                },
	                contentZones: [
	                    { name: "PRD_MALL_MO_div_mcp_rec_mo", selector: "div#mcp_rec_mo" },
	                ],
	                listeners: [

	                // ▼ Add to Cart - 장바구니 버튼 클릭한 경우  
	                    SalesforceInteractions.listener("click", ".btn_cart", (e) => {

	                        SalesforceInteractions.sendEvent({
	                            interaction: {
	                                name: SalesforceInteractions.CartInteractionName.AddToCart,
	                                lineItem: {
	                                        catalogObjectType: "Product",
	                                        catalogObjectId: e.target.previousElementSibling.previousElementSibling.getAttribute("href").replace("/m/products/view/","").trim(),
	                                        price: Number(e.target.previousElementSibling.childNodes[1].childNodes[5].childNodes[3].innerText.replace(/\D/g, "")),
	                                        quantity: 1
	                                },
	                            }
	                        })
	                    }), 
	                
	                ],
	            },

	//------------------------------------------ 로그인 페이지 pageType ------------------------------------------//

	            // ▼ PRD_MALL_PC_Login : 로그인 페이지 
	            {
	                name: "PRD_MALL_PC_login",
	                isMatch: () => /cescomall\.co\.kr\/users\/login/.test(window.location.href),
	                interaction: { 
	                    name: "PRD_MALL_PC - View Login Page"
	                },
	                listeners: [
	                    
	                    // ▼ Login - case 1 - 마우스로 로그인 버튼을 클릭한 경우
	                    SalesforceInteractions.listener("click", "button.btn_type12", () => {
	                        // const user_id = SalesforceInteractions.cashDom("#op_username").val();
	                        const user_id = document.querySelector("#op_username").value;

	                        if(user_id) {
	                            SalesforceInteractions.sendEvent({
	                                interaction: { name: "PRD_MALL_PC - Click Login Button" },
	                                user: { 
	                                    identities: { 
	                                        customerId: user_id,
	                                        profileId: user_id,
	                                    },
	                                }
	                            })
	                        }
	                    }),

	                    // ▼ Login - case 2 - '엔터키 입력'으로 로그인 버튼을 작동시킨 경우
	                    SalesforceInteractions.listener("keydown", "html", (e) => {
	                        if(e.keyCode == 13) {
	                            //  const user_id = SalesforceInteractions.cashDom("#op_username").val();
	                            const user_id = document.querySelector("#op_username").value;

	                            if(user_id) {
	                                SalesforceInteractions.sendEvent({
	                                    interaction: { name: "PRD_MALL_PC - Click Login Button" },
	                                    user: { 
	                                        identities: { 
	                                            customerId: user_id,
	                                            profileId: user_id,
	                                        },
	                                    }
	                                })
	                            }
	                        }
	                    }),

	                ],
	            },

	            // ▼ PRD_MALL_MO_Login : 로그인 페이지
	            {
	                name: "PRD_MALL_MO_login",
	                isMatch: () => /cescomall\.co\.kr\/m\/users\/login/.test(window.location.href),
	                interaction: { 
	                    name: "PRD_MALL_MO - View Login Page"
	                },
	                listeners: [
	                    SalesforceInteractions.listener("click", ".btn_wrap.tp-50 a[class=btn_type4]", () => {
	                        // const user_id = SalesforceInteractions.cashDom("#op_username").val();
	                        const user_id = document.querySelector("#op_username").value;

	                        if(user_id) {
	                            SalesforceInteractions.sendEvent({
	                                interaction: { name: "PRD_MALL_MO - Click Login Button" },
	                                user: { 
	                                    identities: { 
	                                        customerId: user_id,
	                                        profileId: user_id,
	                                    },
	                                }
	                            })
	                        }
	                    }),
	                ],
	            },
	//------------------------------------------ 검색결과 pageType ------------------------------------------//

	            // ▼ PRD_MALL_PC_search_result
	            {
	                name: "PRD_MALL_PC_search_result",
	                isMatch: () => /cescomall\.co\.kr\/cescosearch\/list/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_PC - View Search Result Page",
	                },
	            },

	            // ▼ PRD_MALL_MO_search_result
	            {
	                name: "PRD_MALL_MO_search_result",
	                isMatch: () => /cescomall\.co\.kr\/m\/cescosearch\/list/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_MO - View Search Result Page",
	                },
	            },

	//------------------------------------------ 장바구니 pageType ------------------------------------------//

	            // ▼ PRD_MALL_PC_cart : 장바구니 페이지
	            {
	                name: "PRD_MALL_PC_cart",
	                isMatch: () => /^https:\/\/www\.cescomall\.co\.kr\/cart$/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_PC - View Cart Page"
	                },
	                contentZones:[
	                    {name: "PRD_MALL_cart_rec_pc", selector: "#mcp_cart_rec_pc"},
	                ],
	                listeners: [
	                    // ▼ Replace Cart - 특정 상품의 갯수 변경
	                    SalesforceInteractions.listener("click", ".op-cart-item-table .btn_type6", (e)=>{
	                        const itemList = [];
	                        let targetIndex = null;
	                        const ct = e.currentTarget;

	                        document.querySelectorAll(".op-cart-item-table .btn_type6").forEach((item, index) => {
	                            
	                            const itemInfo = {
	                                catalogObjectType: "Product",
	                                catalogObjectId: item.parentNode.parentNode.querySelector(".num_box3 div").getAttribute("data-store-id"),
	                                quantity: Number(item.parentNode.parentNode.querySelector(".num_box3 div").getAttribute("data-store-qt")),  // 기존 수량
	                                price:Number(item.parentNode.parentNode.parentNode.parentNode.parentNode
	                                    .querySelector(".cart_product_box input").getAttribute("data-appf-price")) ,  // 기존 수량 * 개당 가격
	                                attributes: {
	                                    name: item.parentNode.parentNode.querySelector(".num_box3 div").getAttribute("data-store-nm")
	                                }
	                            };

	                            const eachPrice = Number(itemInfo.price / itemInfo.quantity);  // 개당 가격 

	                            if(ct == item) {
	                                targetIndex = index;
	                                itemInfo.quantity = Number(document.querySelectorAll(".op-cart-item-table .btn_type6")[targetIndex]
	                                    .parentNode.parentNode.querySelector(".num_box3 input").value);  // 변경 눌린 상품의 변경 수량
	                            }

	                            itemInfo.price = eachPrice * itemInfo.quantity;  // 변경 눌린 상품의 변경 가격 (= 개당 가격 * 변경 수량)
	                            
	                            itemList.push(itemInfo);
	                        })

	                        SalesforceInteractions.sendEvent({
	                            interaction: {
	                                name: SalesforceInteractions.CartInteractionName.ReplaceCart,  // MCP Event Stream 에서는 View Cart 로 보임
	                                lineItems: itemList,
	                            }
	                        })
	                    }),
	                    
	                    // ▼ Remove From Cart - 선택 상품 삭제 (Replace Interaction 으로 대체)
	                    SalesforceInteractions.listener("click", ".all_chk_wrap a", (e)=>{
	                        const ItemListAfterDelete = [];

	                        document.querySelectorAll(".op-cart-item-table .btn_type6").forEach((item, index) => {
	                            
	                            const itemInfo = {
	                                catalogObjectType: "Product",
	                                catalogObjectId: item.parentNode.parentNode.querySelector(".num_box3 div").getAttribute("data-store-id"),
	                                quantity: (item.parentNode.parentNode.parentNode.parentNode
	                                        .querySelector(".chk_box.chk_style1 input[type='checkbox']:checked + label") === null)?   // 삭제대상 X 
	                                        Number(item.parentNode.parentNode.querySelector(".num_box3 div").getAttribute("data-store-qt")) : // 기존 수량 (삭제대상 X)
	                                        Number(0), // 삭제대상 O, 수량 0으로 변경
	                                price:Number(item.parentNode.parentNode.parentNode.parentNode.parentNode
	                                    .querySelector(".cart_product_box input").getAttribute("data-appf-price")) ,  // 기존 수량 * 개당 가격
	                                attributes: {
	                                    name: item.parentNode.parentNode.querySelector(".num_box3 div").getAttribute("data-store-nm")
	                                }
	                            };

	                            ItemListAfterDelete.push(itemInfo);
	                        })

	                        SalesforceInteractions.sendEvent({
	                            interaction: {
	                                name: SalesforceInteractions.CartInteractionName.ReplaceCart,  // MCP Event Stream 에서는 View Cart 로 보임
	                                lineItems: ItemListAfterDelete,
	                            }
	                        })
	                    }),

	                ]
	            },

	            // ▼ PRD_MALL_PC_cart_regularcart
	            {
	                name: "PRD_MALL_PC_cart_regularcart",
	                isMatch: () => /^https:\/\/www\.cescomall\.co\.kr\/cart\/regularcart$/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_PC - View RegularCart Page"
	                },
	                contentZones: [
	                    {name: "PRD_MALL_PC_div_mcp_regularcart_rec_pc", selector: "#mcp_car_rec_pc" },
	                ],
	            },
	            
	            // ▼ PRD_MALL_PC_cart_rentalcart
	            {
	                name: "PRD_MALL_PC_cart_rentalcart",
	                isMatch: () => /^https:\/\/www\.cescomall\.co\.kr\/cart\/rentalcart$/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_PC - View RentalCart Page"
	                },
	                contentZones: [
	                    {name: "PRD_MALL_PC_div_mcp_rentalcart_rec_pc", selector: "#mcp_car_rec_pc" },
	                ],
	            },

	            // ▼ PRD_MALL_PC_cart_customcart
	            {
	                name: "PRD_MALL_PC_cart_customcart",
	                isMatch: () => /^https:\/\/www\.cescomall\.co\.kr\/cart\/customcart$/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_PC - View CustomCart Page"
	                },
	                contentZones: [
	                    {name: "PRD_MALL_PC_div_mcp_customcart_rec_pc", selector: "#mcp_car_rec_pc" },
	                ],
	            },

	            // ▼ PRD_MALL_MO_cart : 장바구니 페이지
	            {
	                name: "PRD_MALL_MO_cart",
	                isMatch: () => /^https:\/\/www\.cescomall\.co\.kr\/m\/cart$/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_MO - View Cart Page"
	                },
	                contentZones: [
	                    {name: "PRD_MALL_MO_div_mcp_cart_rec_mo", selector: "#mcp_cart_rec_mo" },
	                ],
	                listeners: [
	                    // ▼ Replace Cart - 특정 상품의 갯수 변경
	                    SalesforceInteractions.listener("click", "#listForm .btn_type11", (e) => {
	                        const itemList = [];
	                        let targetIndex = null;
	                        const ct = e.currentTarget;

	                        document.querySelectorAll("#listForm .btn_type11").forEach((item, index) => {
	                            
	                            const itemInfo = {
	                                catalogObjectType: "Product",
	                                catalogObjectId: item.parentNode.querySelector("div.num_box3 div").getAttribute("data-store-id"),
	                                quantity: Number(item.parentNode.querySelector("div.num_box3 div").getAttribute("data-store-qt")),  // 기존 수량
	                                price:Number(item.parentNode.parentNode.parentNode.parentNode
	                                    .querySelector(".chk_box.chk_style1 input").getAttribute("data-appf-price")),  // 기존 수량 * 개당 가격
	                                attributes: {
	                                    name: item.parentNode.querySelector("div.num_box3 div").getAttribute("data-store-nm")
	                                }
	                            };

	                            const eachPrice = Number(itemInfo.price / itemInfo.quantity);  // 개당 가격 

	                            if(ct == item) {
	                                targetIndex = index;
	                                itemInfo.quantity = Number(document.querySelectorAll("#listForm .btn_type11")[targetIndex]
	                                    .parentNode.parentNode.querySelector(".num_box3 input").value);  // 변경 눌린 상품의 변경 수량
	                            }

	                            itemInfo.price = eachPrice * itemInfo.quantity;  // 변경 눌린 상품의 변경 가격 (= 개당 가격 * 변경 수량)
	                            
	                            itemList.push(itemInfo);
	                        })

	                        SalesforceInteractions.sendEvent({
	                            interaction: {
	                                name: SalesforceInteractions.CartInteractionName.ReplaceCart,  // MCP Event Stream 에서는 View Cart 로 보임
	                                lineItems: itemList,
	                            }
	                        })
	                    }),

	                    // ▼ Remove From Cart - 선택 상품 삭제
	                    SalesforceInteractions.listener("click", "a.btn_remove", (item)=>{

	                        const deletedItem = {
	                            catalogObjectType: "Product",
	                            catalogObjectId: item.currentTarget.parentNode.querySelector("span.check input").getAttribute("data-appf-itemcode"),
	                            quantity: Number(item.currentTarget.parentNode.querySelector("div.num_box3 div").getAttribute("data-store-qt")),
	                            price: Number(item.currentTarget.parentNode.parentNode.parentNode.parentNode
	                                .querySelector(".chk_box.chk_style1 input").getAttribute("data-appf-price")),  // 기존 수량 * 개당 가격
	                            attributes: {
	                                name: item.currentTarget.parentNode.querySelector("div.num_box3 div").getAttribute("data-store-nm")
	                            }
	                        };

	                        SalesforceInteractions.sendEvent({
	                            interaction: {
	                                name: SalesforceInteractions.CartInteractionName.RemoveFromCart,  // MCP Event Stream 에서는 Remove from Cart 로 보임
	                                lineItem: deletedItem,
	                            }
	                        })
	                    }),
	                ]
	            },

	            // ▼ PRD_MALL_MO_cart_regularcart
	            {
	                name: "PRD_MALL_MO_cart_regularcart",
	                isMatch: () =>  {
	                    //페이지 생성 까지 기다림
	                    if (/^https:\/\/www\.cescomall\.co\.kr\/m\/cart\/regularcart$/.test(window.location.href)) {
	                        return new Promise((resolve, reject) => {
	                            let isMatchPDP = setTimeout(() => {
	                                resolve(false);
	                            }, 50);
	                            return SalesforceInteractions.DisplayUtils.pageElementLoaded(
	                                "div#mcp_car_rec_mo",
	                                "html").then(() => {
	                                    clearTimeout(isMatchPDP);
	                                    resolve(true);
	                            });
	                        });
	                    } else {
	                        return false;
	                    }
	                },
	                interaction: {
	                    name: "PRD_MALL_MO - View RegularCart Page"
	                },
	                contentZones: [
	                    {name: "PRD_MALL_MO_div_mcp_regularcart_rec_mo", selector: "div#mcp_car_rec_mo" },
	                ],
	            },
	            
	            // ▼ PRD_MALL_MO_cart_rentalcart
	            {
	                name: "PRD_MALL_MO_cart_rentalcart",
	                isMatch: () =>  {
	                    //페이지 생성 까지 기다림
	                    if (/^https:\/\/www\.cescomall\.co\.kr\/m\/cart\/rentalcart$/.test(window.location.href)) {
	                        return new Promise((resolve, reject) => {
	                            let isMatchPDP = setTimeout(() => {
	                                resolve(false);
	                            }, 50);
	                            return SalesforceInteractions.DisplayUtils.pageElementLoaded(
	                                "div#mcp_car_rec_mo",
	                                "html").then(() => {
	                                    clearTimeout(isMatchPDP);
	                                    resolve(true);
	                            });
	                        });
	                    } else {
	                        return false;
	                    }
	                },
	                interaction: {
	                    name: "PRD_MALL_MO - View RentalCart Page"
	                },
	                contentZones: [
	                    {name: "PRD_MALL_MO_div_mcp_rentalcart_rec_mo", selector: "div#mcp_car_rec_mo" },
	                ],
	            },

	            // ▼ PRD_MALL_MO_cart_customcart
	            {
	                name: "PRD_MALL_MO_cart_customcart",
	                isMatch: () =>  {
	                    //페이지 생성 까지 기다림
	                    if (/^https:\/\/www\.cescomall\.co\.kr\/m\/cart\/customcart$/.test(window.location.href)) {
	                        return new Promise((resolve, reject) => {
	                            let isMatchPDP = setTimeout(() => {
	                                resolve(false);
	                            }, 50);
	                            return SalesforceInteractions.DisplayUtils.pageElementLoaded(
	                                "div#mcp_car_rec_mo",
	                                "html").then(() => {
	                                    clearTimeout(isMatchPDP);
	                                    resolve(true);
	                            });
	                        });
	                    } else {
	                        return false;
	                    }
	                },
	                interaction: {
	                    name: "PRD_MALL_MO - View CustomCart Page"
	                },
	                contentZones: [
	                    {name: "PRD_MALL_MO_div_mcp_customcart_rec_mo", selector: "div#mcp_car_rec_mo" },
	                ],
	            },

	//------------------------------------------ 구매 완료 페이지 pageType ------------------------------------------// 

	            // ▼ PRD_MALL_PC_purchase_finish : 구매 완료 페이지
	            {
	                name: "PRD_MALL_PC_purchase_finish",
	                isMatch: () =>  {
	                    //페이지 생성 까지 기다림
	                    if (/cescomall\.co\.kr\/order\/step3\/0/.test(window.location.href)) {
	                        return new Promise((resolve, reject) => {
	                            let isMatchPDP = setTimeout(() => {
	                                resolve(false);
	                            }, 50);
	                            return SalesforceInteractions.DisplayUtils.pageElementLoaded(
	                                // ".box",
	                                ".btn_type13",
	                                "html").then(() => {
	                                SalesforceInteractions.DisplayUtils.pageElementLoaded(
	                                    ".box.equals .txt2 strong",
	                                    "html").then(() => {
	                                    clearTimeout(isMatchPDP);
	                                    resolve(true);
	                                });
	                            });
	                        });
	                    } else {
	                        return false;
	                    }
	                },
	                interaction: {
	                    name: SalesforceInteractions.OrderInteractionName.Purchase,
	                    order: {
	                        id: window.location.href.split("?")[0].split("/").pop(), 
	                        lineItems: () => {
	                            const ele = document.querySelectorAll(".tbl_wrap7 tbody tr")
	                            const itemList = [];

	                            ele.forEach(function(item){

	                                const itemInfo = {
	                                    catalogObjectType: "Product",
	                                    catalogObjectId: item.querySelector("img").getAttribute("src").split('/')[3],
	                                    quantity: Number(item.querySelectorAll("td")[1].innerHTML),
	                                    price: Number(item.querySelectorAll("td")[4].querySelector("span strong").innerHTML.replace(/\D/g, "")),
	                                }
	                                itemList.push(itemInfo);
	                            })

	                            return itemList;
	                        },
	                        totalValue: () => {
	                            if (!document.querySelector('.box.equals .txt2 strong') != null ) {
	                                return Number(document.querySelector('.box.equals .txt2 strong').textContent.replace(/\D/g, ""));
	                            } else { 
	                                return 0
	                            }
	                            
	                        },

	                        // totalValue: Number(document.querySelector(".box.equals .txt2 strong").innerText),
	                    },
	                },
	            },
	                                
	            // ▼ PRD_MALL_MO_purchase_finish : 구매 완료 페이지
	            {
	                name: "PRD_MALL_MO_purchase_finish",
	                // isMatch: () => /cescomall\.co\.kr\/m\/order\/step3\/0/.test(window.location.href),
	                isMatch: () =>  {
	                    //페이지 생성 까지 기다림
	                    if (/cescomall\.co\.kr\/m\/order\/step3\/0/.test(window.location.href)) {
	                        return new Promise((resolve, reject) => {
	                            let isMatchPDP = setTimeout(() => {
	                                resolve(false);
	                            }, 50);
	                            return SalesforceInteractions.DisplayUtils.pageElementLoaded(
	                                ".btn_type3",
	                                "html").then(() => {
	                                SalesforceInteractions.DisplayUtils.pageElementLoaded(
	                                    ".price_txt.total_price strong b",
	                                    "html").then(() => {
	                                    clearTimeout(isMatchPDP);
	                                    resolve(true);
	                                });
	                            });
	                        });
	                    } else {
	                        return false;
	                    }
	                },
	                interaction: {
	                    name: SalesforceInteractions.OrderInteractionName.Purchase,
	                    order: {
	                        id: window.location.href.split("?")[0].split("/").pop(),
	                        lineItems: () => {
	                            const ele = document.querySelectorAll(".list_pd_pay li")
	                            const itemList = [];

	                            ele.forEach(function(item) {

	                                const itemInfo = {
	                                    catalogObjectType: "Product",
	                                    catalogObjectId: item.querySelector("img").getAttribute("src").split('/')[3],
	                                    quantity: Number(item.querySelector(".txt_wrap .txt2 span").innerHTML.replace("개","")),
	                                    // price: Number(item.querySelector(".box.equals span").innerHTML.replace(/[^\d]/g, '')),
	                                    // 2024_0613_MO 구매페이지 가격 박스 삭제에 따른 조치
	                                    price: 0
	                                };

	                                itemList.push(itemInfo);
	                            })

	                            return itemList;
	                        },
	                        // totalValue: Number(SalesforceInteractions.cashDom(".price_txt.total_price strong b").text().replace(/\D/g, "")),
	                        totalValue: () => {
	                            if (!document.querySelector('.price_txt.total_price strong b') != null ) {
	                                return Number(document.querySelector('.price_txt.total_price strong b').textContent.replace(/\D/g, ""));
	                            } else { 
	                                return 0
	                            }
	                        },
	                        
	                    },
	                },
	            },

	  //------------------------------------------ 마이 페이지  pageType ------------------------------------------//
	            // ▼ PRD_MALL_PC_myPage_order_detail : myPage order detail
	            {
	                name: "PRD_MALL_PC_myPage_order_detail",
	                isMatch: () => /cescomall\.co\.kr\/mypage\/order-detail/.test(window.location.href) ,
	                interaction: {
	                    name: "PRD_MALL_PC - View MyPage Order Detail Page"
	                },
	                listeners: [
	                    // ▼ a 엘리먼트 클릭 시
	                    SalesforceInteractions.listener("click", ".list_order_btn a", (el) => {
	                        console.log('1');
	                        //모달 활성화 Click 체크
	                        let showLayoutClickEvent = (type) => {
	                            let valList = el.target.attributes.onclick.value.replaceAll("Mypage.orderCancelForm('","").replaceAll('Mypage.claimApply(','').replaceAll("'","").replaceAll(')',"").replaceAll(' ',"").split(',');
	                            let orderCode, orderSequence, itemSequence, claimType;
	                            orderCode = valList[0];
	                            orderSequence = valList[1];
	                            itemSequence = valList[2];
	                            claimType  = valList[3]; //2 : 반품 , 3 : 교환 :1,4 취소
	                            let nm = '';

	                            switch (claimType) {
	                                case '2' :
	                                    nm = SalesforceInteractions.OrderInteractionName.Return;
	                                    break;
	                                case '1' :
	                                case '4' :
	                                    nm = SalesforceInteractions.OrderInteractionName.Cancel;
	                                    break;
	                            }

	                            if (nm == '') {
	                                return;
	                            }

	                            let observerAction = (mutation) => {
	                                mutation.target.querySelector('.btn_wrap .btn_type3').addEventListener("click", () => {
	                                    //사유 입력 체크
	                                    let returnChk = () => {
	                                        if($('#claimReason').val() == ""){
	                                            return false;
	                                        }

	                                        if($('#claimReasonDetail').val().length < 10){
	                                            return false;
	                                        }

	                                        if($('#photoAttach').val() == "Y"){
	                                            var fileLength = $("#list_file > li").size();
	                                            if ( 0 >= Number(fileLength)) {
	                                                return false;
	                                            }
	                                        }

	                                        if($('#pgType').val() == "SC0040"){
	                                            if($('#returnBankName').val() == ""){
	                                                return false;
	                                            }

	                                            if($('#returnBankInName').val() == ""){
	                                                return false;
	                                            }

	                                            if($('#returnVirtualNo').val() == ""){
	                                                return false;
	                                            }
	                                        }
	                                        return true;
	                                    }

	                                    if (!returnChk() ) {
	                                        return;
	                                    }

	                                    let itemList = [];
	                                    let totalValue = 0;

	                                    //반품 처리
	                                    if (claimType == 2) {
	                                        let trList = mutation.target.querySelectorAll('.tbl_objection tbody tr');

	                                        trList.forEach(function (item) {

	                                            const itemInfo = {
	                                                catalogObjectType: "Product",
	                                                catalogObjectId: item.querySelector("img").getAttribute("src").split('/')[3],
	                                                quantity: Number(item.querySelector("#applyQuantity").value),
	                                                price: Number(item.querySelectorAll("td")[2].querySelector("span strong").innerHTML.replace(/\D/g, "")),
	                                            }
	                                            itemList.push(itemInfo);
	                                        })
	                                        let totalEl = mutation.target.querySelector('.notice_price #price');

	                                        if (!totalEl != null) {
	                                            totalValue = Number(totalEl.textContent.replace(/\D/g, ""));
	                                        }
	                                    } else {
	                                        let trList = mutation.target.querySelectorAll(".tbl_objection tbody input[type='checkbox']:checked");

	                                        trList.forEach(function (item) {

	                                            const itemInfo = {
	                                                catalogObjectType: "Product",
	                                                catalogObjectId: item.getAttribute("data-appf-itemcode"),
	                                                quantity: Number(item.getAttribute("data-appf-quantity")),
	                                                price: Number(item.getAttribute("data-appf-price")),
	                                            }
	                                            itemList.push(itemInfo);
	                                        })
	                                        let totalEl = mutation.target.querySelector('.pay_both_ends_box .price_txt8');

	                                        if (!totalEl != null) {
	                                            totalValue = Number(totalEl.textContent.replace(/\D/g, ""));
	                                        }
	                                    }


	                                    let order = {
	                                        // id: `${orderCode}`
	                                        id: `${Date.now()}`
	                                        , lineItems: itemList
	                                        , totalValue: totalValue
	                                    };

	                                    SalesforceInteractions.sendEvent({
	                                        interaction: {
	                                            name: nm,
	                                            order: order
	                                        }
	                                    })
	                                })

	                            }
	                            let targetMutation = null;

	                            var cancel_observer = new MutationObserver((mutations) => {
	                                mutations.forEach((mutation) => {
	                                    console.log(`cancel_observer targetMutation : ${targetMutation}`);
	                                    observerAction(targetMutation);
	                                    cancel_observer.disconnect();
	                                })

	                            })

	                            var observer = new MutationObserver((mutations) => {

	                                mutations.forEach((mutation) => {
	                                    console.log(`mutation : ${mutation}`);
	                                    targetMutation = mutation;
	                                    if (claimType == '2') {
	                                        observerAction(targetMutation)
	                                    } else {
	                                        cancel_observer.observe(document.getElementById('cancel_form'), {attributes: true});

	                                    }
	                                    observer.disconnect();
	                                })
	                            });


	                            observer.observe(document.getElementById('layer_claim_form'), {attributes: true});

	                        }


	                        //모달 활성화 체크
	                        let showLayoutEvent = () => {
	                            let valList = el.target.attributes.onclick.value.replaceAll("Mypage.orderCancelForm('","").replaceAll('Mypage.claimApply(','').replaceAll("'","").replaceAll(')',"").replaceAll(' ',"").split(',');
	                            let orderCode, orderSequence, itemSequence, claimType;
	                            orderCode = valList[0];
	                            orderSequence = valList[1];
	                            itemSequence = valList[2];
	                            claimType  = valList[3]; //2 : 반품 , 3 : 교환 :1,4 취소
	                            let nm = '';

	                            switch (claimType) {
	                                case '2' :
	                                    nm = SalesforceInteractions.OrderInteractionName.Return;
	                                    break;
	                                case '1' :
	                                case '4' :
	                                    nm = SalesforceInteractions.OrderInteractionName.Cancel;
	                                    break;
	                            }

	                            if (nm == '') {
	                                return;
	                            }

	                            var observer = new MutationObserver((mutations) => {
	                                mutations.forEach((mutation) => {
	                                    console.log(`mutation : ${mutation}`);
	                                    let trList = mutation.target.querySelectorAll('.tbl_objection tbody tr');
	                                    let itemList = [];

	                                    trList.forEach(function (item) {

	                                        const itemInfo = {
	                                            catalogObjectType: "Product",
	                                            catalogObjectId: item.querySelector("img").getAttribute("src").split('/')[3],
	                                            quantity: Number(item.querySelector("#applyQuantity").value),
	                                            price: Number(item.querySelectorAll("td")[2].querySelector("span strong").innerHTML.replace(/\D/g, "")),
	                                        }
	                                        itemList.push(itemInfo);
	                                    })
	                                    let totalEl = mutation.target.querySelector('.notice_price #price');
	                                    let totalValue = 0;

	                                    if (!totalEl != null) {
	                                        totalValue = Number(totalEl.textContent.replace(/\D/g, ""));
	                                    }

	                                    let order = {
	                                        // id: `${orderCode}`
	                                        id: `${Date.now()}`
	                                        ,lineItems: itemList
	                                        , totalValue: totalValue
	                                    };

	                                    SalesforceInteractions.sendEvent({
	                                        interaction: {
	                                            name: nm,
	                                            order: order
	                                        }
	                                    })
	                                })
	                                observer.disconnect();
	                            });

	                            var config = {
	                                // childList: true,
	                                attributes: true
	                            }

	                            observer.observe(document.getElementById('layer_claim_form'), config);

	                        }

	                        //클릭 이벤트 처리
	                        let clickEvent = () => {
	                            console.log(`액션 : ${el}`);
	                            let valList = el.target.attributes.onclick.value.replaceAll("Mypage.claimApply('","").replaceAll("'","").replaceAll(')',"").replaceAll(' ',"").split(',');
	                            let orderCode, orderSequence, itemSequence, claimType;
	                            orderCode = valList[0];
	                            orderSequence = valList[1];
	                            itemSequence = valList[2];
	                            claimType  = valList[3]; //2 : 반품 , 3 : 교환 :1,4 취소
	                            let nm = '';

	                            switch (claimType) {
	                                case '2' :
	                                    nm = SalesforceInteractions.OrderInteractionName.Return;
	                                    break;
	                                case '1' :
	                                case '4' :
	                                    nm = SalesforceInteractions.OrderInteractionName.Cancel;
	                                    break;
	                            }

	                            if (nm == '') {
	                                return;
	                            }
	                            //상품 정보를 가져 올 방법이 없음...
	                            //묶음  건일 시 짤릴 가능성 있음
	                            //
	                            SalesforceInteractions.sendEvent({
	                                interaction: {
	                                    name: nm,
	                                    order: {
	                                        id: orderCode,
	                                    },
	                                }
	                            })
	                        }
	                        console.log(`list_order_btn a : ${el.target.innerHTML}`);
	                        switch (el.target.innerHTML) {
	                            case '반품신청' :
	                            case '주문취소' :
	                                // clickEvent();
	                                // showLayoutEvent();
	                                showLayoutClickEvent(el.target.innerHTML);
	                                break;

	                            default :
	                                break;
	                        }
	                    })


	                ],

	            },

	            // ▼ PRD_MALL_PC_myPage_order_reutrn_and_cancel : 취소, 반품 클릭
	            {
	                name: "PRD_MALL_PC_myPage_order_reutrn_and_cancel",
	                isMatch: () => /cescomall\.co\.kr\/mypage\/order/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_PC - View MyPage Order Page"
	                },
	                listeners: [
	                    // ▼ a 엘리먼트 클릭 시
	                    SalesforceInteractions.listener("click", ".tbl_wrap1 .list_order_btn a", (el) => {

	                        //모달 활성화 Click 체크
	                        let showLayoutClickEvent = () => {
	                            let valList = el.target.attributes.onclick.value.replaceAll("Mypage.orderCancelForm('","").replaceAll('Mypage.claimApply(','').replaceAll("'","").replaceAll(')',"").replaceAll(' ',"").split(',');
	                            let orderCode, orderSequence, itemSequence, claimType;
	                            orderCode = valList[0];
	                            orderSequence = valList[1];
	                            itemSequence = valList[2];
	                            claimType  = valList[3]; //2 : 반품 , 3 : 교환 :1,4 취소
	                            let nm = '';

	                            switch (claimType) {
	                                case '2' :
	                                    nm = SalesforceInteractions.OrderInteractionName.Return;
	                                    break;
	                                case '1' :
	                                case '4' :
	                                    nm = SalesforceInteractions.OrderInteractionName.Cancel;
	                                    break;
	                            }

	                            if (nm == '') {
	                                return;
	                            }

	                            var observer = new MutationObserver((mutations) => {
	                                mutations.forEach((mutation) => {
	                                    console.log(`mutation : ${mutation}`);
	                                    mutation.target.querySelector('.btn_wrap .btn_type3').addEventListener("click", () => {
	                                        //사유 입력 체크
	                                        let returnChk = () => {
	                                            if($('#claimReason').val() == ""){
	                                                return false;
	                                            }

	                                            if($('#claimReasonDetail').val().length < 10){
	                                                return false;
	                                            }

	                                            if($('#photoAttach').val() == "Y"){
	                                                var fileLength = $("#list_file > li").size();
	                                                if ( 0 >= Number(fileLength)) {
	                                                    return false;
	                                                }
	                                            }

	                                            if($('#pgType').val() == "SC0040"){
	                                                if($('#returnBankName').val() == ""){
	                                                    return false;
	                                                }

	                                                if($('#returnBankInName').val() == ""){
	                                                    return false;
	                                                }

	                                                if($('#returnVirtualNo').val() == ""){
	                                                    return false;
	                                                }
	                                            }
	                                            return true;
	                                        }

	                                        if (!returnChk() ) {
	                                            return;
	                                        }

	                                        let trList = mutation.target.querySelectorAll('.tbl_objection tbody tr');
	                                        let itemList = [];

	                                        trList.forEach(function (item) {

	                                            const itemInfo = {
	                                                catalogObjectType: "Product",
	                                                catalogObjectId: item.querySelector("img").getAttribute("src").split('/')[3],
	                                                quantity: Number(item.querySelector("#applyQuantity").value),
	                                                price: Number(item.querySelectorAll("td")[2].querySelector("span strong").innerHTML.replace(/\D/g, "")),
	                                            }
	                                            itemList.push(itemInfo);
	                                        })
	                                        let totalEl = mutation.target.querySelector('.notice_price #price');
	                                        let totalValue = 0;

	                                        if (!totalEl != null) {
	                                            totalValue = Number(totalEl.textContent.replace(/\D/g, ""));
	                                        }

	                                        let order = {
	                                            // id: `${orderCode} time - ${Date.now()}`
	                                            id: `${Date.now()}`
	                                            ,lineItems: itemList
	                                            , totalValue: totalValue
	                                        };

	                                        SalesforceInteractions.sendEvent({
	                                            interaction: {
	                                                name: nm,
	                                                order: order
	                                            }
	                                        })
	                                    })
	                                })
	                                observer.disconnect();
	                            });

	                            var config = {
	                                // childList: true,
	                                attributes: true
	                            }

	                            observer.observe(document.getElementById('layer_claim_form'), config);

	                        }

	                        //모달 활성화 체크
	                        let showLayoutEvent = () => {
	                            let valList = el.target.attributes.onclick.value.replaceAll("Mypage.claimApply('","").replaceAll("'","").replaceAll(')',"").replaceAll(' ',"").split(',');
	                            let orderCode, orderSequence, itemSequence, claimType;
	                            orderCode = valList[0];
	                            orderSequence = valList[1];
	                            itemSequence = valList[2];
	                            claimType  = valList[3]; //2 : 반품 , 3 : 교환 :1,4 취소
	                            let nm = '';

	                            switch (claimType) {
	                                case '2' :
	                                    nm = SalesforceInteractions.OrderInteractionName.Return;
	                                    break;
	                                case '1' :
	                                case '4' :
	                                    nm = SalesforceInteractions.OrderInteractionName.Cancel;
	                                    break;
	                            }

	                            if (nm == '') {
	                                return;
	                            }

	                            var observer = new MutationObserver((mutations) => {
	                                mutations.forEach((mutation) => {
	                                    console.log(`mutation : ${mutation}`);
	                                    let trList = mutation.target.querySelectorAll('.tbl_objection tbody tr');
	                                    let itemList = [];

	                                    trList.forEach(function (item) {

	                                        const itemInfo = {
	                                            catalogObjectType: "Product",
	                                            catalogObjectId: item.querySelector("img").getAttribute("src").split('/')[3],
	                                            quantity: Number(item.querySelector("#applyQuantity").value),
	                                            price: Number(item.querySelectorAll("td")[2].querySelector("span strong").innerHTML.replace(/\D/g, "")),
	                                        }
	                                        itemList.push(itemInfo);
	                                    })
	                                    let totalEl = mutation.target.querySelector('.notice_price #price');
	                                    let totalValue = 0;

	                                    if (!totalEl != null) {
	                                        totalValue = Number(totalEl.textContent.replace(/\D/g, ""));
	                                    }

	                                    let order = {
	                                        // id: `${orderCode}`
	                                        id: `${Date.now()}`
	                                        ,lineItems: itemList
	                                        , totalValue: totalValue
	                                    };

	                                    SalesforceInteractions.sendEvent({
	                                        interaction: {
	                                            name: nm,
	                                            order: order
	                                        }
	                                    })
	                                })
	                                observer.disconnect();
	                            });

	                            var config = {
	                                // childList: true,
	                                attributes: true
	                            }

	                            observer.observe(document.getElementById('layer_claim_form'), config);

	                        }

	                        //클릭 이벤트 처리
	                        let clickEvent = () => {
	                            console.log(`액션 : ${el}`);
	                            let valList = el.target.attributes.onclick.value.replaceAll("Mypage.claimApply('","").replaceAll("'","").replaceAll(')',"").replaceAll(' ',"").split(',');
	                            let orderCode, orderSequence, itemSequence, claimType;
	                            orderCode = valList[0];
	                            orderSequence = valList[1];
	                            itemSequence = valList[2];
	                            claimType  = valList[3]; //2 : 반품 , 3 : 교환 :1,4 취소
	                            let nm = '';

	                            switch (claimType) {
	                                case '2' :
	                                    nm = SalesforceInteractions.OrderInteractionName.Return;
	                                    break;
	                                case '1' :
	                                case '4' :
	                                    nm = SalesforceInteractions.OrderInteractionName.Cancel;
	                                    break;
	                            }

	                            if (nm == '') {
	                                return;
	                            }
	                            //상품 정보를 가져 올 방법이 없음...
	                            //묶음  건일 시 짤릴 가능성 있음
	                            //
	                            SalesforceInteractions.sendEvent({
	                                interaction: {
	                                    name: nm,
	                                    order: {
	                                        id: orderCode,
	                                    },
	                                }
	                            })
	                        }
	                        console.log(`list_order_btn a : ${el.target.innerHTML}`);
	                        switch (el.target.innerHTML) {
	                            case '반품신청' :
	                            case '취소신청' :
	                                // clickEvent();
	                                //showLayoutEvent();
	                                showLayoutClickEvent();
	                                break;

	                            default :
	                                break;
	                        }
	                    })

	                ],

	            },         

	            // ▼ PRD_MALL_MO_myPage_order_reutrn : 반품 클릭
	            {
	                name: "PRD_MALL_MO_myPage_order_reutrn",
	                isMatch: () => /cescomall\.co\.kr\/m\/order-claim-apply\/return/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_MO - View MyPage Order Page_Reutrn"
	                },
	                listeners: [
	                    // ▼ a 엘리먼트 클릭 시
	                    SalesforceInteractions.listener("click", ".btn_wrap .btn_type4", (el) => {

	                        //사유 입력 체크
	                        let returnChk = () => {

	                            if($('#claimReason').val() == ""){
	                                return false;
	                            }

	                            if($('#claimReasonDetail').val().length < 10){
	                                return false;
	                            }

	                            if($('#photoAttach').val() == "Y"){
	                                var fileLength = $("#list_file > li").size();
	                                if ( 0 >= Number(fileLength)) {
	                                    return false;
	                                }
	                            }

	                            if($('#pgType').val() == "SC0040"){
	                                if($('#returnBankName').val() == ""){
	                                    return false;
	                                }

	                                if($('#returnBankInName').val() == ""){
	                                    return false;
	                                }

	                                if($('#returnVirtualNo').val() == ""){
	                                    return false;
	                                }
	                            }
	                            return true;
	                        }

	                        let clickEventMO = () => {
	                            console.log(`clickEventMO`);
	                            if (!returnChk()) {
	                                return;
	                            }

	                            let nm = SalesforceInteractions.OrderInteractionName.Return;
	                            let trList = document.querySelectorAll('.list_pd_sel');
	                            let itemList = [];

	                            trList.forEach(function (item) {

	                                const itemInfo = {
	                                    catalogObjectType: "Product",
	                                    catalogObjectId: item.querySelector("img").getAttribute("src").split('/')[3],
	                                    quantity: Number(item.querySelector("#applyQuantity").value),
	                                    price: Number(item.querySelector(".txt_wrap").querySelector("span strong").innerHTML.replace(/\D/g, "")),
	                                }
	                                itemList.push(itemInfo);
	                            })
	                            let totalEl = document.querySelector('#returnPrice');
	                            let totalValue = 0;

	                            if (!totalEl != null) {
	                                totalValue = Number(totalEl.textContent.replace(/\D/g, ""));
	                            }

	                            let order = {
	                                // id: document.querySelector('#orderCode').value
	                                id: `${Date.now()}`
	                                ,lineItems: itemList
	                                , totalValue: totalValue
	                            };

	                            SalesforceInteractions.sendEvent({
	                                interaction: {
	                                    name: nm,
	                                    order: order
	                                }
	                            })

	                        }

	                        console.log(`list_order_btn a : ${el.target.innerHTML}`);
	                        clickEventMO();
	                    })

	                ],

	            }, 

	            // ▼ PRD_MALL_MO_myPage_order_cancel : 취소 클릭
	            {
	                name: "PRD_MALL_MO_myPage_order_cancel",
	                isMatch: () =>  {
	                    //페이지 생성 까지 기다림
	                    if (/cescomall\.co\.kr\/m\/order-claim-apply\/cancel/.test(window.location.href)) {
	                        return new Promise((resolve, reject) => {
	                            let isMatchPDP = setTimeout(() => {
	                                resolve(false);
	                            }, 50);
	                            return SalesforceInteractions.DisplayUtils.pageElementLoaded(
	                                ".form_box",
	                                "html").then(() => {
	                                clearTimeout(isMatchPDP);
	                                resolve(true);
	                            });
	                        });
	                    } else {
	                        return false;
	                    }
	                },
	                interaction: {
	                    name: "PRD_MALL_MO - View MyPage Order Page_Cancel"
	                },
	                listeners: [
	                    // ▼ a 화면 로드시
	                    SalesforceInteractions.listener("DOMSubtreeModified", ".form_box", (el) => {
	                        console.log('test');

	                        //사유 입력 체크
	                        let returnChk = () => {

	                            if($('#claimReason').val() == ""){
	                                return false;
	                            }

	                            if($('#claimReasonDetail').val().length < 10){
	                                return false;
	                            }

	                            if($('#photoAttach').val() == "Y"){
	                                var fileLength = $("#list_file > li").size();
	                                if ( 0 >= Number(fileLength)) {
	                                    return false;
	                                }
	                            }

	                            if($('#pgType').val() == "SC0040"){
	                                if($('#returnBankName').val() == ""){
	                                    return false;
	                                }

	                                if($('#returnBankInName').val() == ""){
	                                    return false;
	                                }

	                                if($('#returnVirtualNo').val() == ""){
	                                    return false;
	                                }
	                            }

	                            if ($('input[name="id"]:checked', $('#claimApply')).size() == 0) {
	                                return false;
	                            }

	                            if($('#claimReason').val() == ""){
	                                return;
	                            }

	                            if($('#claimReasonDetail').val() == ""){
	                                return;
	                            }

	                            var claimRefundTypeVal = $(':radio[name="claimRefundType"]:checked').val();

	                            if(claimRefundTypeVal == "2"){

	                                if ($('input[name="returnBankName"]').val() == '') {
	                                    return false;
	                                }

	                                if ($('input[name="returnBankInName"]').val() == '') {
	                                    return false;
	                                }

	                                if ($('input[name="returnVirtualNo"]').val() == '') {
	                                    return false;
	                                }
	                            }

	                            return true;
	                        }
	                        let eventAction = () => {

	                            if (!returnChk()) {
	                                return;
	                            }

	                            let trList = document.querySelectorAll('input[name="id"]:checked');
	                            let itemList = [];

	                            trList.forEach(function (item) {

	                                const itemInfo = {
	                                    catalogObjectType: "Product",
	                                    catalogObjectId: $(item).data('appfItemcode'),
	                                    quantity: Number($(item).data('appfQuantity')),
	                                    price: Number(parseInt($(item).data('appfPrice')) / parseInt($(item).data('appfQuantity'))),
	                                }
	                                itemList.push(itemInfo);
	                            })
	                            let totalEl = document.querySelector('.price_box .box strong');
	                            let totalValue = 0;

	                            if (!totalEl != null) {
	                                totalValue = Number(totalEl.textContent.replace(/\D/g, ""));
	                            }

	                            let order = {
	                                // id: $document.querySelector('#orderCode').value
	                                id: `${Date.now()}`
	                                , lineItems: itemList
	                                , totalValue: totalValue
	                            };

	                            SalesforceInteractions.sendEvent({
	                                interaction: {
	                                    name: SalesforceInteractions.OrderInteractionName.Cancel,
	                                    order: order
	                                }
	                            })
	                        }
	                        console.log('셋팅');

	                        setTimeout(() => {
	                            console.log('시작');
	                            let elt = document.querySelector('.btn_wrap .btn_type3');

	                            if (elt) {
	                                console.log(elt);
	                                elt.removeEventListener("click", eventAction);
	                                elt.addEventListener("click", eventAction);
	                            }

	                        }, 10);
	                        console.log(`list_order_btn`);
	                    })

	                ],

	            },

	//------------------------------------------ 제품 리스트 페이지 pageType ------------------------------------------//    
	            // ▼ PRD_MALL_PC_product_list : 카테고리 별 리스트 페이지 
	            {
	                name: "PRD_MALL_PC_product_list",
	                isMatch: () => /cescomall\.co\.kr\/categories\/index/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_PC - View Product List Page"
	                },
	                listeners: [
	                    // ▼ Add to Cart - case 1 - + 버튼 클릭한 경우  
	                    SalesforceInteractions.listener("click", "div.img a.btn_cart", (e) => {

	                        SalesforceInteractions.sendEvent({
	                            interaction: {
	                                name: SalesforceInteractions.CartInteractionName.AddToCart,
	                                lineItem: {
	                                        catalogObjectType: "Product",
	                                        catalogObjectId: e.target.previousElementSibling.getAttribute("href").match(/G\d+/)[0],
	                                        price: Number(e.target.parentNode.parentNode.childNodes[5].childNodes[3].innerText.replace(/\D/g, "")),
	                                        quantity: 1
	                                },
	                            }
	                        })
	                    }), 

	                    // ▼ Add to Cart - case 2 - 카트담기 버튼 클릭한 경우
	                    SalesforceInteractions.listener("click", "div.img a.btn_cart span", (e) => {
	                        
	                        e.stopPropagation();

	                        SalesforceInteractions.sendEvent({
	                            interaction: {
	                                name: SalesforceInteractions.CartInteractionName.AddToCart,
	                                lineItem: {
	                                        catalogObjectType: "Product",
	                                        catalogObjectId: e.target.parentNode.previousElementSibling.getAttribute("href").match(/G\d+/)[0],
	                                        price: Number(e.target.parentNode.parentNode.parentNode.childNodes[5].childNodes[3].innerText.replace(/\D/g, "")),
	                                        quantity: 1
	                                },
	                            }
	                        })
	                    }), 

	                ],
	            },

	            // ▼ PRD_MALL_MO_product_list : 카테고리 별 리스트 페이지
	            {
	                name: "PRD_MALL_MO_product_list",
	                isMatch: () => /cescomall\.co\.kr\/m\/categories\/index/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_MO - View Product List Page"
	                },
	                listeners: [             

	                    // ▼ Add to Cart - 장바구니 버튼 클릭한 경우    
	                    SalesforceInteractions.listener("click", ".btn_cart", (e) => {

	                        SalesforceInteractions.sendEvent({
	                            interaction: {
	                                name: SalesforceInteractions.CartInteractionName.AddToCart,
	                                lineItem: {
	                                        catalogObjectType: "Product",
	                                        catalogObjectId: e.currentTarget.parentNode.parentNode.querySelector("div a img").getAttribute("src").split("/")[3],
	                                        price: Number(e.currentTarget.parentNode.parentNode.querySelector(".prd_price span strong").innerText.replace(/\D/g, "")),
	                                        quantity: 1
	                                },

	                            }
	                        })
	                    }), 

	                ],
	            },

	//------------------------------------------ 제품 상세 pageType ------------------------------------------//    

	            // ▼ PRD_MALL_PC_product_detail
	            {
	                name: "PRD_MALL_PC_product_detail",
	                isMatch: () => /cescomall\.co\.kr\/products\/view/.test(window.location.href),
	                interaction: {
	                    name: SalesforceInteractions.CatalogObjectInteractionName.ViewCatalogObject,
	                    catalogObject: {
	                        type: "Product",
	                        id: document.location.href.split('/').pop().substr(0,11),
	                    },
	                },
	                listeners: [

	                    // ▼ Add to Cart - case 1 - + 버튼 클릭한 경우  
	                    SalesforceInteractions.listener("click", "div.img a.btn_cart", (e) => {

	                        SalesforceInteractions.sendEvent({
	                            interaction: {
	                                name: SalesforceInteractions.CartInteractionName.AddToCart,
	                                lineItem: {
	                                        price: 3,
	                                        catalogObjectType: "Product",
	                                        catalogObjectId: e.target.previousElementSibling.getAttribute("href").replace("/products/view/","").trim(),
	                                        price: Number(e.target.parentNode.parentNode.querySelector(".product_price span strong").innerText.replace(/\D/g, "")),
	                                        quantity: 1
	                                },
	                            }
	                        })
	                    }), 
	                    
	                    // ▼ Add to Cart - case 2 - 카트담기 버튼 클릭한 경우
	                    SalesforceInteractions.listener("click", "div.img a.btn_cart span", (e) => {
	                        
	                        e.stopPropagation();

	                        SalesforceInteractions.sendEvent({
	                            interaction: {
	                                name: SalesforceInteractions.CartInteractionName.AddToCart,
	                                lineItem: {
	                                        catalogObjectType: "Product",
	                                        catalogObjectId: e.target.parentNode.parentNode.querySelector("a").getAttribute("href").replace("/products/view/","").trim(),
	                                        price: Number(e.target.parentNode.parentNode.parentNode.querySelector(".product_price strong").innerText.replace(/\D/g, "")),
	                                        quantity: 1
	                                },
	                            }
	                        })
	                    }), 

	                    // ▼ Add to Cart - case 3 - 주황색 장바구니 버튼 클릭한 경우  
	                    SalesforceInteractions.listener("click", ".btn_wrap .btn_cart", (e) => {
	                        console.log('btn_wrap');
	                        let total = document.querySelector('.total-amount').innerHTML.replace(/\D/g, "");
	                        let quantity = document.querySelector('.quantity').value.replace(/\D/g, "");

	                        console.log(`total : ${total}`); 
	                        console.log(`quantity : ${quantity}`); 

	                        SalesforceInteractions.sendEvent({
	                            interaction: {
	                                name: SalesforceInteractions.CartInteractionName.AddToCart,
	                                lineItem: {
	                                    catalogObjectType: "Product",
	                                    catalogObjectId: e.currentTarget.parentNode.parentNode.querySelector(".product_sale_info span").innerText.match(/:\s(.*)/)[1],
	                                    price: Number(total),
	                                    quantity: Number(quantity),

	                                    // price: Number(document.querySelector(".btn_total_price.total-amount.opt_total_price").innerText.replace(/\D/g, "")),
	                                    // quantity: Number(e.currentTarget.parentNode.parentNode.querySelector("#cart-item input").getAttribute("value").split("||")[1]),
	                                },
	                            }
	                        })
	                    }), 

	                    // ▼ Add to Cart - case 4 - 제품정보 오른쪽 흰색 장바구니 버튼 클릭한 경우  
	                    SalesforceInteractions.listener("click", ".btn_box .btn_basket", (e) => {

	                        SalesforceInteractions.sendEvent({
	                            interaction: {
	                                name: SalesforceInteractions.CartInteractionName.AddToCart,
	                                lineItem: {
	                                    catalogObjectType: "Product",
	                                    catalogObjectId: document.querySelectorAll(".box span")[0].innerText.replace("상품코드 : ", ""),
	                                    price: Number(e.currentTarget.parentNode.parentNode.querySelector(".btn_total_price").innerText.replace(/\D/g, "")),
	                                    quantity: Number(document.querySelector("input[name='arrayRequiredItems']").getAttribute("value").split("||")[1]),
	                                },
	                            }
	                        })
	                    }),

	                ]
	            }, 

	            // ▼ PRD_MALL_MO_product_detail
	            {
	                name: "PRD_MALL_MO_product_detail",
	                isMatch: () => /cescomall\.co\.kr\/m\/products\/view/.test(window.location.href),
	                interaction: {
	                    name: SalesforceInteractions.CatalogObjectInteractionName.ViewCatalogObject,
	                    catalogObject: {
	                        type: "Product",
	                        id: document.location.href.split('/').pop().substr(0, 11),
	                        attributes: {
	                            name: SalesforceInteractions.cashDom("h1#itemnm").text(),
	                            url: window.location.href.split("?")[0],
	                            imageUrl: () => {
	                                const devurl = document.location.href;
	                                const arr = devurl.split("/");
	                                const domain = arr[0] + "//" + arr[2];
	                                const imgsrc = SalesforceInteractions.cashDom(".swiper-slide.swiper-slide-active div img").attr("src");

	                                return domain + imgsrc;
	                            },
	                            price: Number(SalesforceInteractions.cashDom(".pd_con.normal_item_cls .price_box strong").text().replace(/[^\d]/g, "")),

	                        },
	                    }
	                },
	                listeners: [

	                    // ▼ Add to Cart - case 1 - 장바구니 이모티콘 버튼 클릭한 경우  
	                    SalesforceInteractions.listener("click", ".btn_cart", (e) => {
	                        
	                        SalesforceInteractions.sendEvent({
	                            interaction: {
	                                name: SalesforceInteractions.CartInteractionName.AddToCart,
	                                lineItem: {
	                                        catalogObjectType: "Product",
	                                        catalogObjectId: e.currentTarget.parentNode.parentNode.querySelector(".img a").getAttribute("href").replace("/m/products/view/", "").trim(),
	                                        price: Number(e.currentTarget.parentNode.parentNode.querySelector(".prd_price span strong").innerText.replace(/\D/g, "")),
	                                        quantity: 1
	                                },
	                            }
	                        })
	                    }), 


	                    // ▼ Add to Cart - case 2 - 주황색 장바구니 버튼 클릭한 경우  
	                    SalesforceInteractions.listener("click", ".btn_basket", (e) => {

	                        SalesforceInteractions.sendEvent({
	                            interaction: {
	                                name: SalesforceInteractions.CartInteractionName.AddToCart,
	                                lineItem: {
	                                        catalogObjectType: "Product",
	                                        catalogObjectId: document.location.href.split('/').pop().substr(0, 11),
	                                        price: Number(SalesforceInteractions.cashDom(".price_txt6").text().replace(/[^\d]/g, "")),
	                                        quantity: Number(document.querySelector("#cart-item input").getAttribute("value").split("||")[1]),
	                                },
	                            }
	                        })
	                    }), 
	                    
	                ],
	            },

	//------------------------------------------ 베스트 메뉴 pageType ------------------------------------------//

	            // ▼ PRD_MALL_PC_best_product_list
	            {
	                name: "PRD_MALL_PC_best_product_list",
	                isMatch: () => /cescomall\.co\.kr\/event\/best/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_PC - View Best Product List Page" 
	                },
	                contentZones:[
	                    {name:"PRD_MALL_best_rec_pc", selector: "#mcp_best_rec_pc"},
	                ],
	                listeners: [
	                    // ▼ Add to Cart - case 1 - + 버튼 클릭한 경우  
	                    SalesforceInteractions.listener("click", "div.img a.btn_cart", (e) => {

	                        SalesforceInteractions.sendEvent({
	                            interaction: {
	                                name: SalesforceInteractions.CartInteractionName.AddToCart,
	                                lineItem: {
	                                        catalogObjectType: "Product",
	                                        catalogObjectId: e.target.previousElementSibling.getAttribute("href").match(/'([^']+)'/)[1],
	                                        price: Number(e.target.parentNode.parentNode.childNodes[5].childNodes[3].innerText.replace(/\D/g, "")),
	                                        quantity: 1
	                                },
	                            }
	                        })
	                    }), 

	                    // ▼ Add to Cart - case 2 - 카트담기 버튼 클릭한 경우
	                    SalesforceInteractions.listener("click", "div.img a.btn_cart span", (e) => {
	                        
	                        e.stopPropagation();

	                        SalesforceInteractions.sendEvent({
	                            interaction: {
	                                name: SalesforceInteractions.CartInteractionName.AddToCart,
	                                lineItem: {
	                                        catalogObjectType: "Product",
	                                        catalogObjectId: e.target.parentNode.previousElementSibling.getAttribute("href").match(/'([^']+)'/)[1],
	                                        price: Number(e.target.parentNode.parentNode.parentNode.childNodes[5].childNodes[3].innerText.replace(/\D/g, "")),
	                                        quantity: 1
	                                },
	                            }
	                        })
	                    }), 

	                ]
	            },

	            // ▼ PRD_MALL_MO_best_product_list
	            {
	                name: "PRD_MALL_MO_best_product_list",
	                isMatch: () => /cescomall\.co\.kr\/m\/event\/best/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_MO - View Best Product List Page" 
	                },
	                contentZones:[
	                    {name: "PRD_MALL_best_rec_mo", selector: "#mcp_best_rec_mo"},
	                ],
	                listeners: [

	                // ▼ Add to Cart - 장바구니 버튼 클릭한 경우    
	                    SalesforceInteractions.listener("click", ".btn_cart", (e) => {

	                        SalesforceInteractions.sendEvent({
	                            interaction: {
	                                name: SalesforceInteractions.CartInteractionName.AddToCart,
	                                lineItem: {
	                                        catalogObjectType: "Product",
	                                        catalogObjectId: e.currentTarget.parentNode.parentNode.querySelector("div a img").getAttribute("src").split("/")[3],
	                                        price: Number(e.currentTarget.parentNode.parentNode.querySelector(".prd_price span strong").innerText.replace(/\D/g, "")),
	                                        quantity: 1
	                                },
	                            }
	                        })
	                    }),  

	                ]
	            },

	//------------------------------------------ 매거진 리스트 별 pageType ------------------------------------------//

	            // ▼ PRD_MALL_PC_magazine_list
	            {
	                name: "PRD_MALL_PC_magazine_list",
	                isMatch: () => /cescomall\.co\.kr\/magazine\/list/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_PC - View Magazine List Page"
	                },
	            },

	            // ▼ PRD_MALL_MO_magazine_list
	            {
	                name: "PRD_MALL_MO_magazine_list",
	                isMatch: () => /cescomall\.co\.kr\/m\/magazine\/list/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_MO - View Magazine List Page"
	                }
	            },

	//------------------------------------------ 매거진 회차 별 pageType ------------------------------------------//

	            // ▼ PRD_MALL_PC_magazine_vol01   
	            {
	                name: "PRD_MALL_PC_magazine_vol01",
	                isMatch: () => /cescomall\.co\.kr\/magazine\/pagesMagazine\/magazinevol01/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_PC - View Magazine - Vol 01"
	                },
	                // onActionEvent:(actionEvent) => {

	                //     actionEvent.user = actionEvent.user || {};
	                //     actionEvent.user.attributes = actionEvent.user.attributes || {};
	                //     actionEvent.user.attributes.magazine = "01";

	                //     return actionEvent;
	                // }
	            },

	            // ▼ PRD_MALL_MO_magazine_vol01   
	            {
	                name: "PRD_MALL_MO_magazine_vol01",
	                isMatch: () => /cescomall\.co\.kr\/m\/magazine\/pagesMagazine\/magazinevol01/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_MO - View Magazine - Vol 01"
	                },
	                // onActionEvent:(actionEvent) => {

	                //     actionEvent.user = actionEvent.user || {};
	                //     actionEvent.user.attributes = actionEvent.user.attributes || {};
	                //     actionEvent.user.attributes.magazine = "01";

	                //     return actionEvent;
	                // }
	            },

	            // ▼ PRD_MALL_PC_magazine_vol02  
	            {
	                name: "PRD_MALL_PC_magazine_vol02",
	                isMatch: () => /cescomall\.co\.kr\/magazine\/pagesMagazine\/magazinevol02/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_PC - View Magazine - Vol 02"
	                },
	                // onActionEvent:(actionEvent) => {

	                //     actionEvent.user = actionEvent.user || {};
	                //     actionEvent.user.attributes = actionEvent.user.attributes || {};
	                //     actionEvent.user.attributes.magazine = "02";

	                //     return actionEvent;
	                // }
	            },

	            // ▼ PRD_MALL_MO_magazine_vol02   
	            {
	                name: "PRD_MALL_MO_magazine_vol02",
	                isMatch: () => /cescomall\.co\.kr\/m\/magazine\/pagesMagazine\/magazinevol02/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_MO - View Magazine - Vol 02"
	                },
	                // onActionEvent:(actionEvent) => {

	                //     actionEvent.user = actionEvent.user || {};
	                //     actionEvent.user.attributes = actionEvent.user.attributes || {};
	                //     actionEvent.user.attributes.magazine = "02";

	                //     return actionEvent;
	                // }
	            },

	            // ▼ PRD_MALL_PC_magazine_vol03 
	            {
	                name: "PRD_MALL_PC_magazine_vol03",
	                isMatch: () => /cescomall\.co\.kr\/magazine\/pagesMagazine\/magazinevol03/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_PC - View Magazine - Vol 03"
	                },
	                // onActionEvent:(actionEvent) => {

	                //     actionEvent.user = actionEvent.user || {};
	                //     actionEvent.user.attributes = actionEvent.user.attributes || {};
	                //     actionEvent.user.attributes.magazine = "03";

	                //     return actionEvent;
	                // }
	            },

	            // ▼ PRD_MALL_MO_magazine_vol03   
	            {
	                name: "PRD_MALL_MO_magazine_vol03",
	                isMatch: () => /cescomall\.co\.kr\/m\/magazine\/pagesMagazine\/magazinevol03/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_MO - View Magazine - Vol 03"
	                },
	                // onActionEvent:(actionEvent) => {

	                //     actionEvent.user = actionEvent.user || {};
	                //     actionEvent.user.attributes = actionEvent.user.attributes || {};
	                //     actionEvent.user.attributes.magazine = "03";

	                //     return actionEvent;
	                // }
	            },      

	            // ▼ PRD_MALL_PC_magazine_vol04 
	            {
	                name: "PRD_MALL_PC_magazine_vol04",
	                isMatch: () => /cescomall\.co\.kr\/magazine\/pagesMagazine\/magazinevol04/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_PC - View Magazine - Vol 04"
	                },
	                // onActionEvent:(actionEvent) => {

	                //     actionEvent.user = actionEvent.user || {};
	                //     actionEvent.user.attributes = actionEvent.user.attributes || {};
	                //     actionEvent.user.attributes.magazine = "04";

	                //     return actionEvent;
	                // }
	            },

	            // ▼ PRD_MALL_MO_magazine_vol04   
	            {
	                name: "PRD_MALL_MO_magazine_vol04",
	                isMatch: () => /cescomall\.co\.kr\/m\/magazine\/pagesMagazine\/magazinevol04/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_MO - View Magazine - Vol 04"
	                },
	                // onActionEvent:(actionEvent) => {

	                //     actionEvent.user = actionEvent.user || {};
	                //     actionEvent.user.attributes = actionEvent.user.attributes || {};
	                //     actionEvent.user.attributes.magazine = "04";

	                //     return actionEvent;
	                // }
	            },

	            // ▼ PRD_MALL_PC_magazine_vol05
	            {
	                name: "PRD_MALL_PC_magazine_vol05",
	                isMatch: () => /cescomall\.co\.kr\/magazine\/pagesMagazine\/magazinevol5/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_PC - View Magazine - Vol 05"
	                },
	                // onActionEvent:(actionEvent) => {

	                //     actionEvent.user = actionEvent.user || {};
	                //     actionEvent.user.attributes = actionEvent.user.attributes || {};
	                //     actionEvent.user.attributes.magazine = "05";

	                //     return actionEvent;
	                // }
	            },

	            // ▼ PRD_MALL_MO_magazine_vol05   
	            {
	                name: "PRD_MALL_MO_magazine_vol05",
	                isMatch: () => /cescomall\.co\.kr\/m\/magazine\/pagesMagazine\/magazinevol5/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_MO - View Magazine - Vol 05"
	                },
	                // onActionEvent:(actionEvent) => {

	                //     actionEvent.user = actionEvent.user || {};
	                //     actionEvent.user.attributes = actionEvent.user.attributes || {};
	                //     actionEvent.user.attributes.magazine = "05";

	                //     return actionEvent;
	                // }
	            },

	            // ▼ PRD_MALL_PC_magazine_special
	            {
	                name: "PRD_MALL_PC_magazine_special",
	                isMatch: () => /cescomall\.co\.kr\/magazine\/pagesMagazine\/magazinespecial/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_PC - View Magazine - Special"
	                },
	                // onActionEvent:(actionEvent) => {

	                //     actionEvent.user = actionEvent.user || {};
	                //     actionEvent.user.attributes = actionEvent.user.attributes || {};
	                //     actionEvent.user.attributes.magazine = "special";

	                //     return actionEvent;
	                // }
	            },

	            // ▼ PRD_MALL_MO_magazine_special  
	            {
	                name: "PRD_MALL_MO_magazine_special",
	                isMatch: () => /cescomall\.co\.kr\/m\/magazine\/pagesMagazine\/magazinespecial/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_MO - View Magazine - Special"
	                },
	                // onActionEvent:(actionEvent) => {

	                //     actionEvent.user = actionEvent.user || {};
	                //     actionEvent.user.attributes = actionEvent.user.attributes || {};
	                //     actionEvent.user.attributes.magazine = "special";

	                //     return actionEvent;
	                // }
	            },   

	             // 2024_0613_업데이트  
	             // ▼ PRD_MALL_PC_magazine_vol06
	            {
	                name: "PRD_MALL_PC_magazine_vol06",
	                isMatch: () => /cescomall\.co\.kr\/magazine\/pagesMagazine\/magazinevol6/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_PC - View Magazine - Vol 06"
	                },
	            },

	            // ▼ PRD_MALL_MO_magazine_vol06   
	            {
	                name: "PRD_MALL_MO_magazine_vol06",
	                isMatch: () => /cescomall\.co\.kr\/m\/magazine\/pagesMagazine\/magazinevol6/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_MO - View Magazine - Vol 06"
	                },
	            },        

	//-------------------------------------------------------------------------------------------------------------------//
	//---------------------------------------------------- MY CESCO -----------------------------------------------------//
	//-------------------------------------------------------------------------------------------------------------------//

	//------------------------------------------ 무료진단 솔루션 리스트 pageType ------------------------------------------//

	            // ▼ PRD_MALL_estimate_list
	            {   
	                name: "PRD_MALL_estimate_list",
	                isMatch: () => /cescomall\.co\.kr\/mycesco\/help\/estimate\/main/.test(window.location.href),
	                interaction: { name: "PRD_MALL - View Estimate List Page"},
	            },
	            
	//------------------------------------------ 무료진단 솔루션 별 DB 입력 pageType ------------------------------------------//

	            // ▼ #01 - PRD_MALL_estimate_input_통합해충방제 
	            {
	                name: "PRD_MALL_estimate_input_통합해충방제",
	                // isMatch: () => /cescomall\.co\.kr\/mycesco\/help\/estimate\/save\?code=110602/.test(window.location.href),
	                isMatch: () =>  {
	                    //페이지 생성 까지 기다림
	                    if (/cescomall\.co\.kr\/mycesco\/help\/estimate\/save\?code=110602/.test(window.location.href)) {
	                        return new Promise((resolve, reject) => {
	                            let isMatchPDP = setTimeout(() => {
	                                // console.log('false')
	                                resolve(false);
	                            }, 50);
	                            return SalesforceInteractions.DisplayUtils.pageElementLoaded(
	                                ".btn_wrap a.btn_type4.btn_common",
	                                "html").then(() => {
	                                clearTimeout(isMatchPDP);
	                                //  console.log('true')
	                                resolve(true);
	                            });
	                        });
	                    } else {
	                        return false;
	                    }
	                },
	                interaction: { name: "PRD_MALL - View Estimate Input Page_통합해충방제" },
	                listeners: [
	                    SalesforceInteractions.listener("click", ".btn_wrap a.btn_type4.btn_common", () => {
	                        
	                        const textvalue = SalesforceInteractions.cashDom(".free_request h3").text().substr(0, 6)
	                        SalesforceInteractions.sendEvent({
	                                interaction: { name: "PRD_MALL - Click Estimate Submit Button_통합해충방제" },
	                                user: { 
	                                    attributes: {
	                                        estimateAttribute: true,
	                                        latestEstimate: `${textvalue} 무료진단 제출 버튼 클릭함`,
	                                    },
	                                }
	                        })
	                    })
	                ],
	            }, 

	            // ▼ #02 - PRD_MALL_estimate_input_진드기 케어 
	            {
	                name: "PRD_MALL_estimate_input_진드기 케어",
	                // isMatch: () => /cescomall\.co\.kr\/mycesco\/help\/estimate\/save\?code=110617/.test(window.location.href),
	                isMatch: () =>  {
	                    //페이지 생성 까지 기다림
	                    if (/cescomall\.co\.kr\/mycesco\/help\/estimate\/save\?code=110617/.test(window.location.href)) {
	                        return new Promise((resolve, reject) => {
	                            let isMatchPDP = setTimeout(() => {
	                               // console.log('false')
	                                resolve(false);
	                            }, 50);
	                            return SalesforceInteractions.DisplayUtils.pageElementLoaded(
	                                ".btn_wrap a.btn_type4.btn_tick",
	                                "html").then(() => {
	                                clearTimeout(isMatchPDP);
	                              //  console.log('true')
	                                resolve(true);
	                            });
	                        });
	                    } else {
	                        return false;
	                    }
	                },
	                interaction: { name: "PRD_MALL - View Estimate Input Page_진드기 케어" },
	                listeners: [
	                    // SalesforceInteractions.listener("click", ".btn_wrap a.btn_type4.btn_common", () => {
	                    // 2024_0604_리스너 선택자 수정
	                    SalesforceInteractions.listener("click", ".btn_wrap a.btn_type4.btn_tick", () => {
	                        
	                        const textvalue = SalesforceInteractions.cashDom(".free_request h3").text().substr(0, 6)
	                        SalesforceInteractions.sendEvent({
	                                interaction: { name: "PRD_MALL - Click Estimate Submit Button_진드기 케어" },
	                                user: { 
	                                    attributes: {
	                                        estimateAttribute: true,
	                                        latestEstimate: `${textvalue} 무료진단 제출 버튼 클릭함`,
	                                    },
	                                }
	                        })
	                    })
	                ],
	            }, 

	            // ▼ #03 - PRD_MALL_estimate_input_빈대방제 
	            {
	                name: "PRD_MALL_estimate_input_빈대방제",
	                isMatch: () => /cescomall\.co\.kr\/mycesco\/help\/estimate\/save\?code=110618/.test(window.location.href),
	                interaction: { name: "PRD_MALL - View Estimate Input Page_빈대방제" },
	                listeners: [
	                    // SalesforceInteractions.listener("click", ".btn_wrap a.btn_type4.btn_common", () => {
	                    // 2024_0604_리스너 선택자 수정
	                    SalesforceInteractions.listener("click", ".btn_wrap a.btn_type4.btn_tick", () => {
	                        
	                        const textvalue = SalesforceInteractions.cashDom(".free_request h3").text().substr(0, 4)
	                        SalesforceInteractions.sendEvent({
	                                interaction: { name: "PRD_MALL - Click Estimate Submit Button_빈대방제" },
	                                user: { 
	                                    attributes: {
	                                        estimateAttribute: true,
	                                        latestEstimate: `${textvalue} 무료진단 제출 버튼 클릭함`,
	                                    },
	                                }
	                        })
	                    })
	                ],
	            },            

	            // ▼ #04 - PRD_MALL_estimate_input_향기 컨설팅
	            {
	                name: "PRD_MALL_estimate_input_향기 컨설팅",
	                isMatch: () => /cescomall\.co\.kr\/mycesco\/help\/estimate\/save\?code=110616/.test(window.location.href),
	                interaction: { name: "PRD_MALL - View Estimate Input Page_향기 컨설팅" },
	                listeners: [
	                    SalesforceInteractions.listener("click", ".btn_wrap a.btn_type4.btn_common", () => {
	                        
	                        const textvalue = SalesforceInteractions.cashDom(".free_request h3").text().substr(0, 6)
	                        SalesforceInteractions.sendEvent({
	                                interaction: { name: "PRD_MALL - Click Estimate Submit Button_향기 컨설팅" },
	                                user: { 
	                                    attributes: {
	                                        estimateAttribute: true,
	                                        latestEstimate: `${textvalue} 무료진단 제출 버튼 클릭함`,
	                                    },
	                                }
	                        })
	                    })
	                ],
	            },

	            // ▼ #05 - PRD_MALL_estimate_input_바이러스케어 공기살균기-무료체험 신청
	            {
	                name: "PRD_MALL_estimate_input_바이러스케어 공기살균기-무료체험 신청",
	                isMatch: () => /cescomall\.co\.kr\/mycesco\/help\/estimate\/save\?code=110604\&?kind\=5/.test(window.location.href),
	                interaction: { name: "PRD_MALL - View Estimate Input Page_바이러스케어 공기살균기-무료체험 신청" },
	                listeners: [
	                    SalesforceInteractions.listener("click", ".btn_wrap a.btn_type4.btn_common", () => {
	                        
	                        const textvalue = SalesforceInteractions.cashDom(".free_request h3").text();
	                        SalesforceInteractions.sendEvent({
	                                interaction: { name: "PRD_MALL - Click Estimate Submit Button_바이러스케어 공기살균기-무료체험 신청" },
	                                user: { 
	                                    attributes: {
	                                        estimateAttribute: true,
	                                        latestEstimate: `${textvalue} 제출 버튼 클릭함`,
	                                    },
	                                }
	                        })
	                    })
	                ],
	            }, 

	            // ▼ #06 - PRD_MALL_estimate_input_바이러스케어 공기살균기-무료진단 신청
	            {
	                name: "PRD_MALL_estimate_input_바이러스케어 공기살균기",
	                isMatch: () => /cescomall\.co\.kr\/mycesco\/help\/estimate\/save\?code=110604\&?kind\=1/.test(window.location.href),
	                interaction: { name: "PRD_MALL - View Estimate Input Page_바이러스케어 공기살균기-무료진단 신청" },
	                listeners: [
	                    SalesforceInteractions.listener("click", ".btn_wrap a.btn_type4.btn_common", () => {
	                        
	                        const textvalue = SalesforceInteractions.cashDom(".free_request h3").text();
	                        SalesforceInteractions.sendEvent({
	                                interaction: { name: "PRD_MALL - Click Estimate Submit Button_바이러스케어 공기살균기-무료진단 신청" },
	                                user: { 
	                                    attributes: {
	                                        estimateAttribute: true,
	                                        latestEstimate: `${textvalue} 제출 버튼 클릭함`,
	                                    },
	                                }
	                        })
	                    })
	                ],
	            }, 

	            // ▼ # 07 - PRD_MALL_estimate_input_공기질안심관리 
	            {
	                name: "PRD_MALL_estimate_input_공기질안심관리",
	                isMatch: () => /cescomall\.co\.kr\/mycesco\/help\/estimate\/save\?code=110601/.test(window.location.href),
	                interaction: { name: "PRD_MALL - View Estimate Input Page_공기질안심관리" },
	                listeners: [
	                    SalesforceInteractions.listener("click", ".btn_wrap a.btn_type4.btn_common", () => {
	                        
	                        const textvalue = SalesforceInteractions.cashDom(".free_request h3").text().substr(0, 7)
	                        SalesforceInteractions.sendEvent({
	                                interaction: { name: "PRD_MALL - Click Estimate Submit Button_공기질안심관리" },
	                                user: { 
	                                    attributes: {
	                                        estimateAttribute: true,
	                                        latestEstimate: `${textvalue} 무료진단 제출 버튼 클릭함`,
	                                    },
	                                }
	                        })
	                    })
	                ],
	            },

	            // ▼ #08 - PRD_MALL_estimate_input_수질안심관리
	            {
	                name: "PRD_MALL_estimate_input_수질안심관리",
	                isMatch: () => /cescomall\.co\.kr\/mycesco\/help\/estimate\/save\?code=110608/.test(window.location.href),
	                interaction: { name: "PRD_MALL - View Estimate Input Page_수질안심관리" },
	                listeners: [
	                    SalesforceInteractions.listener("click", ".btn_wrap a.btn_type4.btn_common", () => {
	                        
	                        const textvalue = SalesforceInteractions.cashDom(".free_request h3").text().substr(0, 6)
	                        SalesforceInteractions.sendEvent({
	                                interaction: { name: "PRD_MALL - Click Estimate Submit Button_수질안심관리" },
	                                user: { 
	                                    attributes: {
	                                        estimateAttribute: true,
	                                        latestEstimate: `${textvalue} 무료진단 제출 버튼 클릭함`,
	                                    },
	                                }
	                        })
	                    })
	                ],
	            },

	            // ▼ #09 - PRD_MALL_estimate_input_바디케어 유어핏 비데
	            {
	                name: "PRD_MALL_estimate_input_바디케어 유어핏 비데",
	                isMatch: () => /cescomall\.co\.kr\/mycesco\/help\/estimate\/save\?code=110614/.test(window.location.href),
	                interaction: { name: "PRD_MALL - View Estimate Input Page_바디케어 유어핏 비데" },
	                listeners: [
	                    SalesforceInteractions.listener("click", ".btn_wrap a.btn_type4.btn_common", () => {
	                        
	                        const textvalue = SalesforceInteractions.cashDom(".free_request h3").text().substr(0, 11)
	                        SalesforceInteractions.sendEvent({
	                                interaction: { name: "PRD_MALL - Click Estimate Submit Button_바디케어 유어핏 비데" },
	                                user: { 
	                                    attributes: {
	                                        estimateAttribute: true,
	                                        latestEstimate: `${textvalue} 무료진단 제출 버튼 클릭함`,
	                                    },
	                                }
	                        })
	                    })
	                ],
	            },

	            // ▼ #10 - PRD_MALL_estimate_input_식품안전 
	            {
	                name: "PRD_MALL_estimate_input_식품안전",
	                // isMatch: () => /cescomall\.co\.kr\/mycesco\/help\/estimate\/save\?code=110603/.test(window.location.href),
	                isMatch: () =>  {
	                    //페이지 생성 까지 기다림
	                    if (/cescomall\.co\.kr\/mycesco\/help\/estimate\/save\?code=110603/.test(window.location.href)) {
	                        return new Promise((resolve, reject) => {
	                            let isMatchPDP = setTimeout(() => {
	                                // console.log('false')
	                                resolve(false);
	                            }, 50);
	                            return SalesforceInteractions.DisplayUtils.pageElementLoaded(
	                                ".btn_wrap a.btn_type4.btn_common",
	                                "html").then(() => {
	                                clearTimeout(isMatchPDP);
	                                //  console.log('true')
	                                resolve(true);
	                            });
	                        });
	                    } else {
	                        return false;
	                    }
	                },
	                interaction: { name: "PRD_MALL - View Estimate Input Page_식품안전" },
	                listeners: [
	                    SalesforceInteractions.listener("click", ".btn_wrap a.btn_type4.btn_common", () => {
	                        
	                        const textvalue = SalesforceInteractions.cashDom(".free_request h3").text().substr(0, 4)
	                        SalesforceInteractions.sendEvent({
	                                interaction: { name: "PRD_MALL - Click Estimate Submit Button_식품안전" },
	                                user: { 
	                                    attributes: {
	                                        estimateAttribute: true,
	                                        latestEstimate: `${textvalue} 무료진단 제출 버튼 클릭함`,
	                                    },
	                                }
	                        })
	                    })
	                ],
	            },

	            // ▼ #11 - PRD_MALL_estimate_input_시험분석 
	            {
	                name: "PRD_MALL_estimate_input_시험분석",
	                isMatch: () => /cescomall\.co\.kr\/mycesco\/help\/estimate\/save\?code=110605/.test(window.location.href),
	                interaction: { name: "PRD_MALL - View Estimate Input Page_시험분석" },
	                listeners: [
	                    SalesforceInteractions.listener("click", ".btn_wrap a.btn_type4.btn_common", () => {
	                        
	                        const textvalue = SalesforceInteractions.cashDom(".free_request h3").text().substr(0, 4)
	                        SalesforceInteractions.sendEvent({
	                                interaction: { name: "PRD_MALL - Click Estimate Submit Button_시험분석" },
	                                user: { 
	                                    attributes: {
	                                        estimateAttribute: true,
	                                        latestEstimate: `${textvalue} 무료진단 제출 버튼 클릭함`,
	                                    },
	                                }
	                        })
	                    })
	                ],
	            },
	            
	//-------------------------------------------------------------------------------------------------------------------//
	//-------------------------------------------------- CESCO HOMPAGE --------------------------------------------------//
	//-------------------------------------------------------------------------------------------------------------------//

	//------------------------------------------ 메인 pageType ------------------------------------------//

	            // ▼ PRD_HP_main
	            {
	                name: "PRD_HP_main",
	                isMatch: () => {
	                    let siteSame = 'https://www.cesco.co.kr';     //정확히 동일 할 경우
	                    let siteStart = 'https://www.cesco.co.kr/?'; //로 시작할 경우
	                    return siteSame == window.location.href.substring ||
	                            window.location.href.substring(0, siteStart.length) == siteStart
	                },
	                interaction: {
	                    name: "PRD_HP - View Main Home Page"
	                }
	            },

	//------------------------------------------ 솔루션 소개 페이지별 pageType ------------------------------------------//

	            // ▼ #01 - PRD_HP_solution_information_해충방제 - 통합 해충방제 솔루션
	            {
	                name: "PRD_HP_solution_information_해충방제 - 통합 해충방제 솔루션",
	                isMatch: () => /cesco\.co\.kr\/solution\/service\/total/.test(window.location.href),
	                interaction: {
	                    name: "PRD_HP - View Solution Introduce Page_해충방제 - 통합 해충방제 솔루션"
	                }
	            },

	            // ▼ #02 - PRD_MHP_solution_information_해충방제 - 진드기 솔루션
	            {
	                name: "PRD_HP_solution_information_해충방제 - 진드기 솔루션",
	                isMatch: () => /cesco\.co\.kr\/solution\/service\/tick/.test(window.location.href),
	                interaction: {
	                    name: "PRD_HP - View Solution Introduce Page_해충방제 - 진드기 솔루션"
	                }
	            },

	            // ▼ #03 - PRD_HP_solution_information_해충방제 - 빈대 솔루션
	            {
	                name: "PRD_HP_solution_information_해충방제 - 빈대방제 솔루션",
	                isMatch: () => /cesco\.co\.kr\/solution\/service\/bedbug/.test(window.location.href),
	                interaction: {
	                    name: "PRD_HP - View Solution Introduce Page_해충방제 - 빈대방제 솔루션"
	                }
	            },

	            // ▼ #04 - PRD_HP_solution_information_해충방제 - 비래 해충방제 솔루션
	            {
	                name: "PRD_HP_solution_information_해충방제 - 비래 해충방제 솔루션",
	                isMatch: () => /cesco\.co\.kr\/solution\/service\/fly/.test(window.location.href),
	                interaction: {
	                    name: "PRD_HP - View Solution Introduce Page_해충방제 - 비래 해충방제 솔루션"
	                }
	            },

	            // ▼ #05 - PRD_HP_solution_information_해충방제 - 모기 솔루션
	            {
	                name: "PRD_HP_solution_information_해충방제 - 모기 솔루션",
	                isMatch: () => /cesco\.co\.kr\/solution\/service\/mosquito/.test(window.location.href),
	                interaction: {
	                    name: "PRD_HP - View Solution Introduce Page_해충방제 - 모기 솔루션"
	                }
	            },

	            // ▼ #06 - PRD_HP_solution_information_바이러스케어 솔루션
	            {
	                name: "PRD_HP_solution_information_바이러스케어 솔루션",
	                isMatch: () => /cesco\.co\.kr\/solution\/service\/virusCare/.test(window.location.href),
	                interaction: {
	                    name: "PRD_HP - View Solution Introduce Page_바이러스케어 솔루션"
	                }
	            },

	            // ▼ #07 - PRD_HP_solution_information_식품안전 솔루션
	            {
	                name: "PRD_HP_solution_information_식품안전 솔루션",
	                isMatch: () => /cesco\.co\.kr\/solution\/service\/food/.test(window.location.href),
	                interaction: {
	                    name: "PRD_HP - View Solution Introduce Page_식품안전 솔루션"
	                },
	            },

	            // ▼ #08 - PRD_HP_solution_information_환경가전 - 공기살균기
	            {
	                name: "PRD_HP_solution_information_환경가전 - 공기살균기",
	                isMatch: () => /cesco\.co\.kr\/solution\/service\/airSterile/.test(window.location.href),
	                interaction: {
	                    name: "PRD_HP - View Solution Introduce Page_환경가전 - 공기살균기"
	                }
	            },

	            // ▼ #09 - PRD_HP_solution_information_환경가전 - 공기살균청정기
	            {
	                name: "PRD_HP_solution_information_환경가전 - 공기살균청정기",
	                isMatch: () => /cesco\.co\.kr\/solution\/service\/dualcare/.test(window.location.href),
	                interaction: {
	                    name: "PRD_HP - View Solution Introduce Page_환경가전 - 공기살균청정기"
	                }
	            },

	            // ▼ #10 - PRD_HP_solution_information_환경가전 - 공기청정기
	            {
	                name: "PRD_HP_solution_information_환경가전 - 공기청정기",
	                isMatch: () => /cesco\.co\.kr\/solution\/service\/air/.test(window.location.href),
	                interaction: {
	                    name: "PRD_HP - View Solution Introduce Page_환경가전 - 공기청정기"
	                }
	            },

	            // ▼ #11 - PRD_HP_solution_information_환경가전 - 정수기
	            {
	                name: "PRD_HP_solution_information_환경가전 - 정수기",
	                isMatch: () => /cesco\.co\.kr\/solution\/service\/water/.test(window.location.href),
	                interaction: {
	                    name: "PRD_HP - View Solution Introduce Page_환경가전 - 정수기"
	                }
	            },

	            // ▼ #12 - PRD_HP_solution_information_환경가전 - 향기솔루션 에어퍼퓸
	            {
	                name: "PRD_HP_solution_information_환경가전 - 향기솔루션 에어퍼퓸",
	                isMatch: () => /cesco\.co\.kr\/solution\/service\/scent/.test(window.location.href),
	                interaction: {
	                    name: "PRD_HP - View Solution Introduce Page_환경가전 - 향기솔루션 에어퍼퓸"
	                }
	            },

	            // ▼ #13 - PRD_HP_solution_information_환경가전 - 비데
	            {
	                name: "PRD_HP_solution_information_환경가전 - 비데",
	                isMatch: () => /cesco\.co\.kr\/solution\/service\/bodyCare/.test(window.location.href),
	                interaction: {
	                    name: "PRD_HP - View Solution Introduce Page_환경가전 - 비데"
	                }
	            },

	            // ▼ #14 - PRD_HP_solution_information_생활위생용품
	            {
	                name: "PRD_HP_solution_information_생활위생용품",
	                isMatch: () => /cesco\.co\.kr\/solution\/service\/mylab/.test(window.location.href),
	                interaction: {
	                    name: "PRD_HP - View Solution Introduce Page_생활위생용품"
	                }
	            },

	            // ▼ #15 - PRD_HP_solution_information_분석서비스 - 시험분석 서비스
	            {
	                name: "PRD_HP_solution_information_분석서비스 - 시험분석 서비스",
	                isMatch: () => /cesco\.co\.kr\/solution\/service\/exam/.test(window.location.href),
	                interaction: {
	                    name: "PRD_HP - View Solution Introduce Page_분석서비스 - 시험분석 서비스"
	                }
	            },

	            // ▼ #16 - PRD_HP_solution_information_분석서비스 - 이물분석 서비스
	            {
	                name: "PRD_HP_solution_information_분석서비스 - 이물분석 서비스",
	                isMatch: () => /cesco\.co\.kr\/solution\/service\/alien/.test(window.location.href),
	                interaction: {
	                    name: "PRD_HP - View Solution Introduce Page_분석서비스 - 이물분석 서비스"
	                }
	            },



	//-------------------------------------------------------------------------------------------------------------------//
	//------------------------------------------------- MEMBERS LOUNGE --------------------------------------------------//
	//-------------------------------------------------------------------------------------------------------------------//

	//------------------------------------------ 멤버스 신청 완료 pageType ------------------------------------------//

	            // ▼ PRD_MALL_MEMBERS_LOUNGE_MARK_COMPLETE
	            {
	                name: "PRD_MALL_MEMBERS_LOUNGE_MARK_COMPLETE",
	                isMatch: () => /cescomall\.co\.kr\/members\/mark\/markComplete/.test(window.location.href),
	                interaction: { name: "PRD_MALL - View Members Lounge Mark Complete Page"},
	                contentZones: [ 
	                    {name: "PRD_MALL_PC_div_mcp_markcomplete_rec", selector: "div#mcp_markcomplete_rec"}
	                ],
	            },



	//-------------------------------------------------------------------------------------------------------------------//
	//------------------------------------------ 시나리오 관련 없는 pagetype  --------------------------------------------//
	//-------------------------------------------------------------------------------------------------------------------//

	//------------------------------------------ 마이세스코 메뉴 관련 pageType ------------------------------------------//

	            // ▼ PRD_MALL_MYCESCO_MAIN
	            {
	                name: "PRD_MALL_MYCESCO_MAIN",
	                isMatch: () =>  {
	                    //페이지 생성 까지 기다림
	                    if (/cescomall\.co\.kr\/mycesco/.test(window.location.href)) {
	                        return new Promise((resolve, reject) => {
	                            let isMatchPDP = setTimeout(() => {
	                                resolve(false);
	                            }, 50);
	                            return SalesforceInteractions.DisplayUtils.pageElementLoaded(
	                                ".main_search",
	                                "html").then(() => {
	                                clearTimeout(isMatchPDP);
	                                let returnData = document.querySelector(".main_search").innerText === "궁금한 점이 있으신가요?\n검색버튼";
	                                resolve(returnData);
	                            });
	                        });
	                    } else {
	                        return false;
	                    }
	                },
	                interaction: { name: "PRD_MALL - View My Cesco Main Page"},
	            },
	            
	            // ▼ PRD_MALL_MYCESCO_SOLUTION_SERVICE
	            {
	                name: "PRD_MALL_MYCESCO_SOLUTION_SERVICE",
	                isMatch: () => {
	                    return (/cescomall\.co\.kr\/mycesco\/membercontract/.test(window.location.href) ||
	                            /cescomall\.co\.kr\/mycesco\/paymentlist/.test(window.location.href) ||
	                            /cescomall\.co\.kr\/mycesco\/paymenthistory/.test(window.location.href) ||
	                            /cescomall\.co\.kr\/mycesco\/regularvisit/.test(window.location.href) ||
	                            /cescomall\.co\.kr\/mycesco\/servicereport/.test(window.location.href) ||
	                            /cescomall\.co\.kr\/mycesco\/solution\/foreign/.test(window.location.href) ||
	                            /cescomall\.co\.kr\/mycesco\/certdisinfection/.test(window.location.href) )
	                },
	                interaction: { name: "PRD_MALL - View My Cesco Solution Service Menus"},
	            },
	            
	            // ▼ PRD_MALL_MYCESCO_GUIDE
	            {
	                name: "PRD_MALL_MYCESCO_GUIDE",
	                isMatch: () => {
	                    return (/cescomall\.co\.kr\/mycesco\/guide\/product/.test(window.location.href) ||
	                            /cescomall\.co\.kr\/mycesco\/guide\/faq/.test(window.location.href) )
	                },
	                interaction: { name: "PRD_MALL - View My Cesco Guide Menus"},
	            },
	            
	            // ▼ PRD_MALL_MYCESCO_HELP
	            {
	                name: "PRD_MALL_MYCESCO_HELP",
	                isMatch: () => {
	                    return (/cescomall\.co\.kr\/mycesco\/help\/promotion/.test(window.location.href) ||
	                            /cescomall\.co\.kr\/mycesco\/help\/membersdown/.test(window.location.href) ||
	                            /cescomall\.co\.kr\/mycesco\/help\/qna\/list/.test(window.location.href) ||
	                            /cescomall\.co\.kr\/mycesco\/help\/catalog/.test(window.location.href) ||
	                            /cescomall\.co\.kr\/mycesco\/help\/joinrecommend/.test(window.location.href) )
	                },
	                interaction: { name: "PRD_MALL - View My Cesco Help Menus"},
	            },

	            // ▼ PRD_MALL_MYCESCO_PLAZA
	            {
	                name: "PRD_MALL_MYCESCO_PLAZA",
	                isMatch: () => {
	                    return (/cescomall\.co\.kr\/mycesco\/plaza\/notice/.test(window.location.href) ||
	                            /cescomall\.co\.kr\/mycesco\/plaza\/review/.test(window.location.href) ||
	                            /cescomall\.co\.kr\/mycesco\/plaza\/compliment/.test(window.location.href) )
	                },
	                interaction: { name: "PRD_MALL - View My Cesco Plaza Menus"},
	            },

	//------------------------------------------ 기획전 관련 pageType ------------------------------------------//
	            // ▼ PRD_MALL_PC_featured_list
	            {
	                name: "PRD_MALL_PC_featured_list",
	                isMatch: () => /cescomall\.co\.kr\/featured\/list/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_PC - View Featured List Page"
	                },
	            },

	            // ▼ PRD_MALL_MO_featured_list
	            {
	                name: "PRD_MALL_MO_featured_list",
	                isMatch: () => /cescomall\.co\.kr\/m\/featured/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_MO - View Featured List Page"
	                },
	            },
	            
	            // ▼ PRD_MALL_PC_featured_detail
	            {
	                name: "PRD_MALL_PC_featured_detail",
	                isMatch: () => /cescomall\.co\.kr\/pages/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_PC - View Featured Detail Page"
	                },
	            },

	            // ▼ PRD_MALL_MO_featured_detail
	            {
	                name: "PRD_MALL_MO_featured_detail",
	                isMatch: () => /cescomall\.co\.kr\/m\/pages/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_MO - View Featured Detail Page"
	                },
	            },

	//------------------------------------------ 이벤트 관련 pageType ------------------------------------------//

	            // ▼ PRD_MALL_PC_event_list
	            {
	                name: "PRD_MALL_PC_event_list",
	                isMatch: () => {
	                    return (/cescomall\.co\.kr\/event\/progressList/.test(window.location.href) ||
	                            /cescomall\.co\.kr\/event\/pastList/.test(window.location.href) )
	                },
	                interaction: {
	                    name: "PRD_MALL_PC - View Event List Page"
	                },
	            },

	            // ▼ PRD_MALL_MO_event_list
	            {
	                name: "PRD_MALL_MO_event_list",
	                isMatch: () => {
	                    return (/cescomall\.co\.kr\/m\/event\/progressList/.test(window.location.href) ||
	                            /cescomall\.co\.kr\/m\/event\/pastList/.test(window.location.href) )
	                },
	                interaction: {
	                    name: "PRD_MALL_MO - View Event List Page"
	                },
	            },

	            // ▼ PRD_MALL_PC_event_detail
	            {
	                name: "PRD_MALL_PC_event_detail",
	                isMatch: () => /cescomall\.co\.kr\/event\/pagesEvent/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_PC - View Event Detail Page"
	                },
	            },

	            // ▼ PRD_MALL_MO_event_detail
	            {
	                name: "PRD_MALL_MO_event_detail",
	                isMatch: () => /cescomall\.co\.kr\/m\/event\/pagesEvent/.test(window.location.href),
	                interaction: {
	                    name: "PRD_MALL_MO - View Event Detail Page"
	                },
	            },

	            // 2024-06-20 이충현 수정, 세스코 마블 캠페인 이벤트 페이지 pageTypes 선언
	            // ▼ PRD_HP_PC_event_CESCO_MARVEL
	            {
	                name: "PRD_HP_PC_event_CESCO_MARVEL",
	                // isMatch: () => /cesco\.co\.kr\/homepage\/newsletter/.test(window.location.href),
	                isMatch: () => /cesco\.co\.kr\/homepage\/newsletter\/detail\?newsletterId=11/.test(window.location.href),
	                interaction: {
	                    name: "PRD_HP_PC - View MARVEL Event Detail Page"
	                },
	            },
	                    
	        ]
	}

	    SalesforceInteractions.initSitemap(sitemapConfig);
	});
}
